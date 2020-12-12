package me.hydos.arms.client.screen;

import me.hydos.arms.compiler.Compiler;
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
	private List<String> fileLines;

	public AsmEditorScreen(BlockPos pos) {
		super(new LiteralText("Turn Off Narrator"));
		this.pos = pos;
	}

	@Override
	public void filesDragged(List<Path> paths) {
		try {
			final List<String> lines = Files.readAllLines(paths.get(0));
			this.fileLines = lines;
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
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		super.render(matrices, mouseX, mouseY, delta);
		drawCenteredText(matrices, textRenderer, new LiteralText("Drag and Drop"), this.width / 2, 4, 0xFFFFFFFF);
		drawCenteredText(matrices, textRenderer, new LiteralText("A File Here!"), this.width / 2, 14, 0xFFFFFFFF);
		if (fileLines != null) {
			drawCenteredText(matrices, textRenderer, new LiteralText("Assembly:"), this.width / 4, 30, 0xFFFFFFFF);
			for (int i = 0; i < fileLines.size(); i++) {
				client.textRenderer.draw(matrices, Compiler.colourAsm(fileLines.get(i)), 4, 40 + (10 * i), 0xFFFFFFFF);
			}
		}
	}
}
