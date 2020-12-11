package me.hydos.arms.compiler.processor;

import me.hydos.arms.compiler.CodeProcessor;
import me.hydos.arms.compiler.CpuState;
import me.hydos.arms.compiler.instruction.Instruction;
import me.hydos.arms.compiler.instruction.Instructions;
import me.hydos.arms.compiler.instruction.NOPInstruction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionProcessor implements CodeProcessor {

	@Override
	public boolean canProcess(String line) {
		return !line.equals("");
	}

	@Override
	public String process(String line, CpuState state) {
		parseInstruction(line.split(" "), state);
		return line;
	}

	private void parseInstruction(String[] line, CpuState state) {
		String name = line[0];
		String arg1 = line[1];
		String arg2 = line[2];
		Instruction instruction = Instructions.INSTRUCTIONS.getOrDefault(name, new NOPInstruction());
		instruction.compile(arg1, arg2, state);
	}
}
