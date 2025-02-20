package mrchumbucket.meatblock.item;

import mrchumbucket.meatblock.MeatBlock;
import mrchumbucket.meatblock.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_MEAT_BLOCK = registerItem("raw_meat_block", new BlockItem(ModBlocks.RAW_MEAT_BLOCK, new Item.Settings().food(ModFoodComponents.RAW_MEAT_BLOCK)));
    public static final Item SPOILED_MEAT_BLOCK = registerItem("spoiled_meat_block", new BlockItem(ModBlocks.SPOILED_MEAT_BLOCK, new Item.Settings().food(ModFoodComponents.SPOILED_MEAT_BLOCK)));
    public static final Item COOKED_MEAT_BLOCK = registerItem("cooked_meat_block", new BlockItem(ModBlocks.COOKED_MEAT_BLOCK, new Item.Settings().food(ModFoodComponents.COOKED_MEAT_BLOCK)));

    private static Item registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, Identifier.of(MeatBlock.MOD_ID, name), item);
        return item;
    }

    public static void registerModItems() {
        MeatBlock.LOGGER.info("Registering Mod Blocks for " + MeatBlock.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(RAW_MEAT_BLOCK);
            entries.add(SPOILED_MEAT_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(RAW_MEAT_BLOCK);
            entries.add(SPOILED_MEAT_BLOCK);
            entries.add(COOKED_MEAT_BLOCK);
        });


    }
}
