package me.hydos.arms.compiler.instruction.api;

import me.hydos.arms.compiler.CpuState;

public interface Instruction {

	void compile(CpuState state, Argument[] args);

	Argument[] getArgs();

	String getComment();

	void addArg(Argument nextArg);

	String getName();

	void uncacheData();
}
