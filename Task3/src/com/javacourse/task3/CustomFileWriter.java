package com.javacourse.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CustomFileWriter {

	public static void printContent(String string) {
		System.out.println(string.toString());
	}

	public static void writeStringToFile(String string, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(string);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}