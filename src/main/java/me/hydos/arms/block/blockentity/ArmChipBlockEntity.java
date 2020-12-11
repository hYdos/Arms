package me.hydos.arms.block.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

public class ArmChipBlockEntity extends BlockEntity {

	public ArmChipBlockEntity() {
		super(BlockEntities.ARM_CHIP_BLOCK);
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		return super.toTag(tag);
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		super.fromTag(state, tag);
	}
}
