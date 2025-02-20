package mrchumbucket.meatblock.mixin;

import mrchumbucket.meatblock.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonHandler.class)
public class PistonHandlerMixin {

    @Inject(at = @At("HEAD"), method = "isBlockSticky", cancellable = true)
    private static void isBlockSticky(BlockState state, CallbackInfoReturnable<Boolean> info) {
        if(state.isOf(ModBlocks.RAW_MEAT_BLOCK) || state.isOf(ModBlocks.SPOILED_MEAT_BLOCK)) {
            info.setReturnValue(true);
        }
    }

    @Inject(at = @At("HEAD"), method = "isAdjacentBlockStuck", cancellable = true)
    private static void isAdjacentBlockStuck(BlockState state, BlockState adjacentState, CallbackInfoReturnable<Boolean> cir) {
        boolean isMeat = state.isOf(ModBlocks.RAW_MEAT_BLOCK) || state.isOf(ModBlocks.SPOILED_MEAT_BLOCK);
        boolean isAdjacentMeat = adjacentState.isOf(ModBlocks.RAW_MEAT_BLOCK) || adjacentState.isOf(ModBlocks.SPOILED_MEAT_BLOCK);

        if (isMeat && (adjacentState.isOf(Blocks.SLIME_BLOCK) || adjacentState.isOf(Blocks.HONEY_BLOCK))) {
            cir.setReturnValue(false);
        } else if (state.isOf(Blocks.SLIME_BLOCK) && isAdjacentMeat) {
            cir.setReturnValue(false);
        } else if (state.isOf(Blocks.HONEY_BLOCK) && isAdjacentMeat) {
            cir.setReturnValue(false);
        }
    }
}
