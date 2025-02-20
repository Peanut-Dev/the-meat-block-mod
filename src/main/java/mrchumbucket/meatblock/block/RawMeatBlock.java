package mrchumbucket.meatblock.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.Optional;

public class RawMeatBlock extends SlidingBlock {
    public RawMeatBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0F, world.getDamageSources().fall());
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f = 0.05688889F;
        if (random.nextFloat() < f) {
            this.tryDegrade( world, pos, random).ifPresent(degraded -> world.setBlockState(pos, degraded));
        }
    }

    protected Optional<BlockState> tryDegrade(ServerWorld world, BlockPos pos, Random random) {
        int i = 1;
        int j = 0;

        for (BlockPos blockPos : BlockPos.iterateOutwards(pos, 4, 4, 4)) {
            int l = blockPos.getManhattanDistance(pos);

            if (l > 4) {
                break;
            }

            if (!blockPos.equals(pos) && world.getBlockState(blockPos).getBlock() instanceof RawMeatBlock) {
                j++;
			}
        }

        float f = 1 / (float)(j + 1);
        float g = f * f;
        return random.nextFloat() < g ? Optional.of(ModBlocks.SPOILED_MEAT_BLOCK.getDefaultState()) : Optional.empty();
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected byte getEntityStatus() {
        return 99;
    }
}
