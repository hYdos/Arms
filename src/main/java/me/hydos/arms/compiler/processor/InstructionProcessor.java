package me.hydos.arms.compiler.processor;

import me.hydos.arms.compiler.CodeProcessor;
import me.hydos.arms.compiler.CpuState;
import me.hydos.arms.compiler.instruction.api.Instruction;
import me.hydos.arms.compiler.instruction.Instructions;
import me.hydos.arms.compiler.instruction.impl.NoOpInstruction;

public class InstructionProcessor implements CodeProcessor {

	@Override
	public boolean canProcess(String line) {
		return !line.equals("") && !(line.startsWith("//") || line.startsWith("@"));
	}

	@Override
	public String process(String line, CpuState state) {
		parseInstruction(line, state);
		return line;
	}

	private void parseInstruction(String line, CpuState state) {
		Instruction instruction = Instructions.parse(line);
		instruction.compile(state, instruction.getArgs());
	}
}
