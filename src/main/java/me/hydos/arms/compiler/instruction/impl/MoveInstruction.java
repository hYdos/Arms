package me.hydos.arms.compiler.instruction.impl;

import me.hydos.arms.compiler.CpuState;
import me.hydos.arms.compiler.RegistryUtils;
import me.hydos.arms.compiler.instruction.api.AbstractInstruction;
import me.hydos.arms.compiler.instruction.api.Argument;

public class MoveInstruction extends AbstractInstruction {

	public MoveInstruction() {
		super("MOV");
	}

	@Override
	public void compile(CpuState state, Argument[] args) {
		byte value = RegistryUtils.getValue(args[0].getValue(), state);
		RegistryUtils.setRegister(args[1].getValue(), value, state);
	}
}
