package com.javacourse.task3.selectors;

public class WordSelectorByPatternAndReplacer implements WordSelector{ 
	private String regexp;
	private String replacement;

	public WordSelectorByPatternAndReplacer(String regexp, String replacement) {
		this.regexp = regexp;
		this.replacement = replacement;
	}

	@Override
	public String doSelect(String line) {
		return line.replaceAll(regexp, replacement);
	}
}