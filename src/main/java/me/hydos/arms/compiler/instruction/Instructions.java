package me.hydos.arms.compiler.instruction;

import me.hydos.arms.compiler.instruction.api.Argument;
import me.hydos.arms.compiler.instruction.api.Instruction;
import me.hydos.arms.compiler.instruction.api.ValueType;
import me.hydos.arms.compiler.instruction.impl.AddInstruction;
import me.hydos.arms.compiler.instruction.impl.MoveInstruction;
import me.hydos.arms.compiler.instruction.impl.NoOpInstruction;

import java.util.*;

public class Instructions {
	public static final Map<String, Instruction> INSTRUCTIONS = new HashMap<>();

	static {
		INSTRUCTIONS.put("MOV", new MoveInstruction());
		INSTRUCTIONS.put("ADD", new AddInstruction());
		INSTRUCTIONS.put("NOP", new NoOpInstruction());
	}

	/**
	 * parses a line into a valid instruction
	 *
	 * @param line the line to read
	 * @return a processor instruction
	 */
	public static Instruction parse(String line) {
		//Rules to follow by:
		//The first split is the instruction
		String[] split = line.split(" ");
		String instructionName = split[0].toUpperCase();
		Instruction instruction = INSTRUCTIONS.get(instructionName);
		if (instruction == null) {
			throw new RuntimeException("Unable to find instruction: " + instructionName);
		}
		instruction.uncacheData();
		List<Argument> args = getAllArgs(split);
		for (Argument arg : args) {
			instruction.addArg(arg);
		}
		return instruction;
	}

	private static List<Argument> getAllArgs(String[] split) {
		List<Argument> arguments = new ArrayList<>();
		for (int i = 1; i < split.length; i++) {
			String part = split[i].toUpperCase();
			part = part.replace(",", ""); // Remove fancy asm language things
			if (!part.equals(" ") && !part.equals("")) {
				if (part.startsWith("//") || part.startsWith("@")) { // Check if whole line is a comment or blank line
					return arguments; // Because the rest of the line is a comment
				}
				if (part.startsWith("R")) { // Must be a registry
					arguments.add(new Argument(ValueType.REGISTER, part));
				} else if (part.startsWith("0X")) { // Must be a byte value
					arguments.add(new Argument(ValueType.BYTE, Byte.parseByte(part.replace("0X", ""))));
				} else if (part.startsWith("#")) { // Must be a number value
					arguments.add(new Argument(ValueType.NUMBER, Integer.parseInt(part.replace("#", ""))));
				} else { // Well fuck
					throw new RuntimeException("We cant parse the argument: " + part);
				}
			}
		}
		return arguments;
	}
}
