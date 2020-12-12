package me.hydos.arms.compiler.processor;

import me.hydos.arms.compiler.CodeProcessor;

import java.util.ArrayList;
import java.util.List;

public class Processors {

	public static final List<CodeProcessor> PROCESSORS = new ArrayList<>();

	static {
		PROCESSORS.add(new CommaPreProcessor());
		PROCESSORS.add(new InstructionProcessor());
	}
}
