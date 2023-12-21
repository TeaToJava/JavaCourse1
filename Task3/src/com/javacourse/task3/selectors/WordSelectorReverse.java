package com.javacourse.task3.selectors;

public class WordSelectorReverse implements WordSelector {

	@Override
	public String doSelect(String line) {
		StringBuilder reversedLine = new StringBuilder(line).reverse();
		return reversedLine.toString();
	}

}