package me.hydos.arms;

import me.hydos.arms.block.Blocks;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Arms implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("Arms");

	@Override
	public void onInitialize() {
		LOGGER.info("Your (Server's) gonna have a bad time..."); // Im joking please let this mod in FabricSMP i worked hard on it :pensive:
		Blocks.registerBlocks();
	}
}
