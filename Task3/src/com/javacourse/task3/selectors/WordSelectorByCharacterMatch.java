package com.javacourse.task3.selectors;

import java.util.LinkedHashSet;
import java.util.Set;

public class WordSelectorByCharacterMatch implements WordSelector {
	private String wordFromPreviousLine = null;

	@Override
	public String doSelect(String line) {
		String[] array = line.split(DELIMETER);
		Set<String> wordSet = new LinkedHashSet<>();
		String first = wordFromPreviousLine;
		for (int i = 0; i < array.length; i++) {
			String second = array[i];
			if (first != null) {
				char lastCharOfFirstWord = first.charAt(first.length() - 1);
				char firstCharOfSecondWord = second.charAt(0);
				if (lastCharOfFirstWord == firstCharOfSecondWord) {
					wordSet.add(first);
					wordSet.add(second);
				}
			}
			first = second;
			if (i == array.length - 1) {
				wordFromPreviousLine = second;
			}
		}
		return String.join(" ", wordSet);
	}

}