package me.hydos.arms.compiler;

import me.hydos.arms.compiler.instruction.api.Instruction;
import me.hydos.arms.compiler.instruction.Instructions;
import net.minecraft.text.LiteralText;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.List;

public class Compiler {

	// Public methods
	public static void run(CpuState state, List<CodeProcessor> processors) {
		if (state.asm.length == 0) {
			return;
		}
		if (state.asm.length != state.PC) {
			String codeLine = state.asm[state.PC];
			for (CodeProcessor processor : processors) {
				if (processor.canProcess(codeLine)) {
					codeLine = processor.process(codeLine, state);
				}
			}
			state.PC++;
		}

	}

	public static Text colourAsm(String line) {
		if(line.startsWith("//") || line.startsWith("@") || line.equals("")){ // Check if whole line is a comment or blank line
			return new LiteralText("§2" + line);
		}else{
			Instruction instruction = Instructions.parse(line);
			MutableText text = new LiteralText("§e" + instruction.getName());
			for (int i = 0; i < instruction.getArgs().length; i++) {
				text.append("§3 " + instruction.getArgs()[i].getValue());
			}
			if(instruction.getComment() != null && !instruction.getComment().equals("")){
				text.append("§2 //" + instruction.getComment());
			}
			return text;
		}
	}
}
