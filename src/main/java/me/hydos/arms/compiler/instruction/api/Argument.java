package me.hydos.arms.compiler.instruction.api;

public class Argument {

	private final ValueType type;
	private final Object value;

	public ValueType getType() {
		return this.type;
	}

	public String getValue() {
		if (type == ValueType.BYTE) {
			return "0x" + value;
		}
		if (type == ValueType.NUMBER) {
			return "#" + value;
		}
		// Fallback
		return value.toString();
	}

	public Object getRawValue() {
		return value;
	}

	public Argument(ValueType type, Object value) {
		this.type = type;
		this.value = value;
	}

}
