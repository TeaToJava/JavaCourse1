package com.javacourse.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.javacourse.task3.selectors.WordSelector;

public class CustomFileReader {
	private StringBuilder stringBuilder = new StringBuilder();

	public void readFileAndSelect(String path, WordSelector wordSelector) {
		if (wordSelector != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(wordSelector.doSelect(line) +"\n");
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	public String getFileData() {
		return stringBuilder.toString();
	}

}