package me.hydos.arms.compiler;

import me.hydos.arms.compiler.processor.Processors;

import java.util.List;

public class Compiler {

	// Public methods
	public static void compile(String[] code, CpuState state, List<CodeProcessor> preProcessors) {
		state.clear();
		state.asm = code;

		for (String codeLine : code) {
			for (CodeProcessor preProcessor : preProcessors) {
				if(preProcessor.canProcess(codeLine)){
					codeLine = preProcessor.process(codeLine, state);
				}
			}
		}
	}
}
