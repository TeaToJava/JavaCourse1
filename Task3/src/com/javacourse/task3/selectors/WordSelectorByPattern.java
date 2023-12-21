package com.javacourse.task3.selectors;

public class WordSelectorByPattern implements WordSelector {
	public String pattern;

	public WordSelectorByPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String doSelect(String line) {
		String[] array = line.split(DELIMETER);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			String string = array[i];
			if (string.matches(pattern)) {
				stringBuilder.append(string + " ");
			}
		}
		return stringBuilder.toString();
	}

}