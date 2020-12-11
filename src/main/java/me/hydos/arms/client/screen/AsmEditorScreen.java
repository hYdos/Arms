package me.hydos.arms.client.screen;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AsmEditorScreen extends Screen {

	private static final Path ASM_DIR = FabricLoader.getInstance().getGameDir().resolve("asm");
	private final BlockPos pos;

	public AsmEditorScreen(BlockPos pos) {
		super(new LiteralText("Yes"));
		this.pos = pos;
	}

	@Override
	public void filesDragged(List<Path> paths) {
		try {
			final List<String> file = Files.readAllLines(paths.get(0));
			System.out.println(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		System.out.println(pos);
		this.addButton(new ButtonWidget(0, 0, 200, 20, new LiteralText("Send to Server"), button -> {
			System.out.println("Yes");
		}));
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		super.render(matrices, mouseX, mouseY, delta);
	}
}
