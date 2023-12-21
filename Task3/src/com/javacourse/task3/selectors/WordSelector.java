package com.javacourse.task3.selectors;

public interface WordSelector {
	final static String DELIMETER = "[\\p{Punct}\\s]+";

	public String doSelect(String line);
}