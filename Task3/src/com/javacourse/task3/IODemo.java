package com.javacourse.task3;

import java.io.File;

import com.javacourse.task3.selectors.WordSelectorByCharacterMatch;
import com.javacourse.task3.selectors.WordSelectorByPattern;
import com.javacourse.task3.selectors.WordSelectorByPatternAndReplacer;
import com.javacourse.task3.selectors.WordSelectorDigitsLogic;
import com.javacourse.task3.selectors.WordSelectorReverse;

public class IODemo {
	private static final String VOWELS_PATTERN = "^[аеёиоуыэюя].*";
	private static final String JAVA = ".java";
	private static final String PUBLIC_PATTERN = "public(?! class %s| %s)";
	private static final String PRIVATE = "private";

	public static void main(String[] args) {
		// Task 1
		String path = args[0];
		FileUtils.readFromFileAndDisplay(path, new WordSelectorByPattern(VOWELS_PATTERN));

		// Task 2
		FileUtils.readFromFileAndDisplay(path, new WordSelectorByCharacterMatch());

		// Task 3
		FileUtils.readFromFileAndDisplay(path, new WordSelectorDigitsLogic());

		// Task 4
		String inputJavaFile = args[1];
		String outputJavaFile = args[2];
		File file = new File(inputJavaFile);
		String fileName = file.getName().replace(JAVA, "");
		String publicRegexp = String.format(PUBLIC_PATTERN, fileName, fileName);
		FileUtils.readFromFileAndWriteToFile(inputJavaFile, outputJavaFile,
				new WordSelectorByPatternAndReplacer(publicRegexp, PRIVATE));

		// Task 5
		String outputJavaReverseFile = args[3];
		FileUtils.readFromFileAndWriteToFile(inputJavaFile, outputJavaReverseFile, new WordSelectorReverse());
	}

}