package me.hydos.arms.compiler.instruction;

import me.hydos.arms.compiler.CpuState;

public class MoveInstruction implements Instruction {

	@Override
	public void compile(String arg1, String arg2, CpuState state) {
		//TODO: use regex to check if its a register or byte
		try {
			byte value = Byte.parseByte(arg1.replace("0x", ""));
			CpuState.class.getDeclaredField(arg2).setByte(state, value);
		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
