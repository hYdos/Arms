package me.hydos.arms.client;

import me.hydos.arms.client.screen.AsmEditorScreen;
import me.hydos.arms.network.Networking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.math.BlockPos;

public class ClientArms implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientPlayNetworking.registerGlobalReceiver(Networking.OPEN_COOL_SCREEN, (client, handler, buf, responseSender) -> {
			BlockPos pos = buf.readBlockPos();
			client.execute(() -> client.openScreen(new AsmEditorScreen(pos)));
		});
	}
}
