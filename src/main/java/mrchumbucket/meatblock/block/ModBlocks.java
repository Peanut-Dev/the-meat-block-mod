package mrchumbucket.meatblock.block;

import net.minecraft.block.*;
import mrchumbucket.meatblock.MeatBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block RAW_MEAT_BLOCK = registerBlock("raw_meat_block",
            new RawMeatBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE)
                    .nonOpaque().slipperiness(1F).sounds(BlockSoundGroup.MUD)));

    public static final Block COOKED_MEAT_BLOCK = registerBlock("cooked_meat_block",
            new TranslucentBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)
                    .sounds(BlockSoundGroup.HANGING_ROOTS)));


    public static final Block SPOILED_MEAT_BLOCK = registerBlock("spoiled_meat_block",
            new SpoiledMeatBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN)
                    .nonOpaque().slipperiness(1F).sounds(BlockSoundGroup.HONEY)));

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MeatBlock.MOD_ID, name), block);
    }


    public static void registerModBlocks() {
        MeatBlock.LOGGER.info("Registering Mod Blocks for " + MeatBlock.MOD_ID);
    }
}
