package com.javacourse.task3;

import com.javacourse.task3.selectors.WordSelector;

public class FileUtils {

	public static void readFromFileAndDisplay(String path, WordSelector wordSelector) {
		String data = getDataFromFile(path, wordSelector);
		CustomFileWriter.printContent(data);
	}

	public static void readFromFileAndWriteToFile(String inputPath, String outputPath, WordSelector wordSelector) {
		String data = getDataFromFile(inputPath, wordSelector);
		CustomFileWriter.writeStringToFile(data, outputPath);
	}
	
	private static String getDataFromFile(String path, WordSelector wordSelector) {
		CustomFileReader fileReader = new CustomFileReader();
		fileReader.readFileAndSelect(path, wordSelector);
		return fileReader.getFileData();
	}

}