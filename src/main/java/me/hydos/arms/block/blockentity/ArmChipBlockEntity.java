package me.hydos.arms.block.blockentity;

import me.hydos.arms.compiler.Compiler;
import me.hydos.arms.compiler.CpuState;
import me.hydos.arms.compiler.processor.Processors;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Tickable;

public class ArmChipBlockEntity extends BlockEntity implements Tickable {

	public CpuState state = new CpuState();

	public ArmChipBlockEntity() {
		super(BlockEntities.ARM_CHIP_BLOCK);
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		tag.put("state", this.state.toTag(new CompoundTag()));
		return super.toTag(tag);
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		this.state = CpuState.fromTag((CompoundTag) tag.get("state"));
		super.fromTag(state, tag);
	}

	@Override
	public void tick() {
		int redstonePower = world.getReceivedRedstonePower(pos);
		if(redstonePower != 0){
			Compiler.run(state, Processors.PROCESSORS);
		}
	}
}
