package me.hydos.arms.compiler.instruction;

import me.hydos.arms.compiler.CpuState;
import me.hydos.arms.compiler.RegistryUtils;

public class MoveInstruction implements Instruction {

	@Override
	public void compile(String arg1, String arg2, CpuState state) {
		byte value = RegistryUtils.getValue(arg1, state);
		RegistryUtils.setRegister(arg2.toUpperCase(), value, state);
	}
}
