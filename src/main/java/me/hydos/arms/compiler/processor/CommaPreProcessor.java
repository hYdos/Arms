package me.hydos.arms.compiler.processor;

import me.hydos.arms.compiler.CodeProcessor;
import me.hydos.arms.compiler.CpuState;

public class CommaPreProcessor implements CodeProcessor {
	@Override
	public boolean canProcess(String line) {
		return true;
	}

	@Override
	public String process(String line, CpuState state) {
		return line.replace(",", "");
	}
}
