package me.hydos.arms.compiler.processor;

import me.hydos.arms.compiler.CodeProcessor;
import me.hydos.arms.compiler.CpuState;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentPreProcessor implements CodeProcessor {

	private static final Pattern PATTERN_COMMENT = Pattern.compile("#.*$");

	@Override
	public boolean canProcess(String line) {
		return line.contains("#");
	}

	@Override
	public String process(String line, CpuState state) {
		Matcher commentMatcher = PATTERN_COMMENT.matcher(line);
		return commentMatcher.replaceFirst("").trim();
	}
}
