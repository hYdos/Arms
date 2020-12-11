package me.hydos.arms.client.screen;

import me.hydos.arms.network.Networking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AsmEditorScreen extends Screen {

	private static final Path ASM_DIR = FabricLoader.getInstance().getGameDir().resolve("asm");
	private final BlockPos pos;

	public AsmEditorScreen(BlockPos pos) {
		super(new LiteralText("Turn Off Narrator"));
		this.pos = pos;
	}

	@Override
	public void filesDragged(List<Path> paths) {
		try {
			final List<String> lines = Files.readAllLines(paths.get(0));
			StringBuilder file = new StringBuilder();
			for (String line : lines) {
				file.append(line).append("\n");
			}
			PacketByteBuf buf = PacketByteBufs.create();
			buf.writeBlockPos(this.pos);
			buf.writeString(file.toString());
			ClientPlayNetworking.send(Networking.SEND_FILE, buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		System.out.println(pos);
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		super.render(matrices, mouseX, mouseY, delta);
	}
}
