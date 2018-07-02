package com.siri.pojo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	public void writeToFile(String filePath, String fileName, String content) throws IOException {
		try {
			File file = new File("C:\\Users\\bhara\\eclipse-workspace\\POJO\\Output.txt");
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter bufWriter = new BufferedWriter(writer);
			bufWriter.write(content + "\n");
			bufWriter.close();
		} catch (Exception e) {
			System.out.println("ERROR in writing the file");
		}
	}

	public void writeToFileGetAndSet(String filePath, String content2) throws IOException {
		try {
			// creates object for file
			File file = new File("C:\\Users\\bhara\\eclipse-workspace\\POJO\\Output.txt");
			// If file Output.txt is open, continue writing into it.
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter bufWriter = new BufferedWriter(writer);
			bufWriter.write(content2 + "\n");
			bufWriter.close();
		} catch (Exception e) {
			System.out.println("ERROR in writing the file");
		}

	}

}
