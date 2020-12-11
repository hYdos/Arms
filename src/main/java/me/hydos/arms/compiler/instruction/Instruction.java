package me.hydos.arms.compiler.instruction;

import me.hydos.arms.compiler.CpuState;

public interface Instruction {

	void compile(String arg1, String arg2, CpuState state);
}
