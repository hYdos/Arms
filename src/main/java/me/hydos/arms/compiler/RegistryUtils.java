package me.hydos.arms.compiler;

public class RegistryUtils {
	public static byte getValue(String value, CpuState state) {
		byte cleanValue;
		if (value.startsWith("R")) {// must be a registry
			cleanValue = getRegistryValue(value, state);
		} else { // has to be an byte. parse it as if it was
			cleanValue = Byte.parseByte(value.replace("0x", ""));
		}
		return cleanValue;
	}

	private static byte getRegistryValue(String registerStr, CpuState state) {
		return state.registers[getRawRegistry(registerStr)];
	}

	private static int getRawRegistry(String registerStr) {
		int register = Integer.parseInt(registerStr.substring(1));
		if (register > 13) {
			throw new RuntimeException("Cannot find register: " + register);
		}
		return register;
	}

	public static void setRegister(String register, byte value, CpuState state) {
		state.registers[getRawRegistry(register)] = value;
	}
}
