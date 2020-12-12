package me.hydos.arms.compiler.instruction.api;

import me.hydos.arms.Arms;

public abstract class AbstractInstruction implements Instruction{

	public Argument[] args = new Argument[0];
	public String comment;
	public final String name;

	public AbstractInstruction(String name) {
		this.name = name;
	}

	@Override
	public Argument[] getArgs() {
		return args;
	}

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void addArg(Argument nextArg) {
		args = Arms.safeAppendToArray(args, nextArg);
	}

	@Override
	public void uncacheData() {
		args = new Argument[0];
		comment = "";
	}
}
