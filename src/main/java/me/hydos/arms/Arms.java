package me.hydos.arms;

import me.hydos.arms.block.Blocks;
import me.hydos.arms.block.blockentity.ArmChipBlockEntity;
import me.hydos.arms.network.Networking;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Arms implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("Arms");

	@Override
	public void onInitialize() {
		LOGGER.info("Your (Server's) gonna have a bad time..."); // Im joking please let this mod in FabricSMP i worked hard on it :pensive:
		Blocks.registerBlocks();

		ServerPlayNetworking.registerGlobalReceiver(Networking.SEND_FILE, (server, player, serverPlayNetworkHandler, buf, sender) -> {
			BlockPos pos = buf.readBlockPos();
			String chunk = buf.readString(32767);
			server.execute(() -> {
				ArmChipBlockEntity armChipBlockEntity = ((ArmChipBlockEntity) player.getServerWorld().getBlockEntity(pos));
				if (armChipBlockEntity != null) {
					Arrays.stream(chunk.split("\n")).forEach(line -> armChipBlockEntity.state.asm = safeAppendToArray(armChipBlockEntity.state.asm, line));
				}
			});
		});
	}

	private String[] safeAppendToArray(String[] asm, String line) {
		String[] asm2 = Arrays.copyOf(asm, asm.length + 1);
		asm2[asm2.length - 1] = line;
		return asm2;
	}
}
