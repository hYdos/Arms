package me.hydos.arms.compiler;

import java.util.Collection;

public class CpuState {

	// Registers
	public byte R0;
	public byte R1;
	public byte R2;
	public byte R3;
	public byte R4;
	public byte R5;
	public byte R6;
	public byte R7; // Holds Syscall Number
	public byte R8;
	public byte R9;
	public byte R10;
	public byte R11; // Frame pointer
	public byte R12; // Intra Procedural Call
	public byte R13; // Stack pointer //Alias is SP

	// Misc
	public String[] asm;

	public void clear() {
		this.R0 = 0;
		this.R1 = 0;
		this.R2 = 0;
		this.R3 = 0;
		this.R4 = 0;
		this.R5 = 0;
		this.R6 = 0;
		this.R7 = 0;
		this.R8 = 0;
		this.R9 = 0;
		this.R10 = 0;
		this.R11 = 0;
		this.R12 = 0;
		this.R13 = 0;
	}
}
