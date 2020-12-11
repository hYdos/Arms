package me.hydos.arms.compiler;

import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;

public class CpuState {

	byte[] registers = new byte[13];

	//Registers
	//R7 Holds Syscall Number
	//R11= Frame pointer
	//R12= Intra Procedural Call
	//R13= Stack pointer //Alias is SP

	// Misc
	public String[] asm;
	public byte PC;

	public CpuState() {
		asm = new String[0];
	}

	public static CpuState fromTag(CompoundTag tag){
		CpuState state = new CpuState();
		if(tag == null){
			return state;
		}
		state.registers = tag.getByteArray("registry");

		state.PC = tag.getByte("pc");
		state.asm = fromTagString(tag.getList("code", NbtType.STRING).toArray(new StringTag[0]));

		return state;
	}

	private static String[] fromTagString(StringTag[] codes) {
		String[] stringArray = new String[codes.length];
		for (int i = 0; i < codes.length; i++) {
			stringArray[i] = codes[i].asString();
		}
		return stringArray;
	}

	public CompoundTag toTag(CompoundTag tag){
		ByteArrayTag registryArray = new ByteArrayTag(registers);
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
