package me.hydos.arms.compiler.instruction.impl;

import me.hydos.arms.compiler.CpuState;
import me.hydos.arms.compiler.instruction.api.AbstractInstruction;
import me.hydos.arms.compiler.instruction.api.Argument;

public class NoOpInstruction extends AbstractInstruction {

	public NoOpInstruction() {
		super("NOP");
	}

	@Override
	public void compile(CpuState state, Argument[] args) {

	}
}
