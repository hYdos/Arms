package me.hydos.arms.compiler;

import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;

import java.util.Arrays;

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
	public byte PC;

	public CpuState() {
		asm = new String[0];
	}

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

	public static CpuState fromTag(CompoundTag tag){
		CpuState state = new CpuState();
		if(tag == null){
			return state;
		}
		byte[] registry = tag.getByteArray("registry");
		state.R0 = registry[0];
		state.R1 = registry[1];
		state.R2 = registry[2];
		state.R3 = registry[3];
		state.R4 = registry[4];
		state.R5 = registry[5];
		state.R6 = registry[6];
		state.R7 = registry[7];
		state.R8 = registry[8];
		state.R9 = registry[9];
		state.R10 = registry[10];
		state.R11 = registry[11];
		state.R12 = registry[12];
		state.R13 = registry[13];

		state.PC = tag.getByte("pc");
		state.asm = (String[]) tag.getList("code", NbtType.STRING).toArray();

		return state;
	}

	public CompoundTag toTag(CompoundTag tag){
		ByteArrayTag registryArray = new ByteArrayTag(Arrays.asList(R0, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13));
		ListTag code = new ListTag();
		for (String line : asm) {
			code.add(StringTag.of(line));
		}
		tag.put("registry", registryArray);
		tag.putByte("pc", PC);
		tag.put("code", code);
		return tag;
	}
}
