package me.hydos.arms.block.blockentity;

import me.hydos.arms.compiler.CpuState;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

public class ArmChipBlockEntity extends BlockEntity{

	public String asm = "";
	public CpuState state = new CpuState();

	public ArmChipBlockEntity() {
		super(BlockEntities.ARM_CHIP_BLOCK);
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		tag.put("state", this.state.toTag(new CompoundTag()));
		tag.putString("asm", this.asm);
		return super.toTag(tag);
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		this.asm = tag.getString("asm");
		this.state = CpuState.fromTag((CompoundTag) tag.get("state"));
		super.fromTag(state, tag);
	}

}
