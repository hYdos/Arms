package me.hydos.arms.block;

import me.hydos.arms.block.blockentity.BlockEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {

	public static final ArmChipBlock ARM_CHIP_BLOCK = new ArmChipBlock(FabricBlockSettings.of(Material.METAL, DyeColor.BLACK));

	public static void registerBlocks(){
		BlockEntities.register();
		Registry.register(Registry.BLOCK, new Identifier("arms", "arm_chip"), ARM_CHIP_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("arms", "arm_chip"), new BlockItem(ARM_CHIP_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
	}
}
