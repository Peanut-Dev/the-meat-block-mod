package mrchumbucket.meatblock;

import mrchumbucket.meatblock.block.ModBlocks;
import mrchumbucket.meatblock.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeatBlock implements ModInitializer {
	public static final String MOD_ID = "meat-block";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}