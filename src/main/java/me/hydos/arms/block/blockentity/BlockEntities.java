package me.hydos.arms.block.blockentity;

import me.hydos.arms.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntities {
	public static BlockEntityType<?> ARM_CHIP_BLOCK;

	public static void register(){
		ARM_CHIP_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("arms", "arm_chip"), BlockEntityType.Builder.create(ArmChipBlockEntity::new, Blocks.ARM_CHIP_BLOCK).build(null));
	}
}
