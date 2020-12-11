package me.hydos.arms.compiler;

import me.hydos.arms.compiler.processor.Processors;

import java.util.List;

public class Compiler {

	// Public methods
	public static void run(CpuState state, List<CodeProcessor> processors) {
		if(state.asm.length == 0){
			return;
		}
		if(state.asm.length != state.PC){
			String codeLine = state.asm[state.PC];
			for (CodeProcessor processor : processors) {
				if(processor.canProcess(codeLine)){
					codeLine = processor.process(codeLine, state);
				}
			}
			state.PC++;
		}

	}
}
