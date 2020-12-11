package me.hydos.arms.compiler.instruction;

import java.util.HashMap;
import java.util.Map;

public class Instructions {
	public static final Map<String, Instruction> INSTRUCTIONS = new HashMap<>();

	static {
		INSTRUCTIONS.put("MOV", new MoveInstruction());
	}
}
