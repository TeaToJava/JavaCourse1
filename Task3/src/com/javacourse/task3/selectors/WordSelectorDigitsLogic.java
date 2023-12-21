package com.javacourse.task3.selectors;

public class WordSelectorDigitsLogic implements WordSelector {
	private static final String DIGITS_PATTERN = "\\d+";

	@Override
	public String doSelect(String line) {
		String[] array = line.split(DELIMETER);
		String maxDigit = "";
		for (int i = 0; i < array.length; i++) {
			String str = array[i];
			if ((maxDigit.isBlank() && str.matches(DIGITS_PATTERN))
					|| (!maxDigit.isBlank() && maxDigit.length() > str.length())) {
				maxDigit = str;
			}
		}
		return maxDigit;
	}
}