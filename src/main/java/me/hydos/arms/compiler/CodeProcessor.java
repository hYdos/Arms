package me.hydos.arms.compiler;

public interface CodeProcessor {

	boolean canProcess(String line);

	String process(String line, CpuState state);
}
