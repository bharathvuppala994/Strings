package com.siri.pojo;

import java.io.IOException;

public class Tester {

	public static void main(String[] args) {
		Reader readfile = new Reader();
		Writer writefile = new Writer();
		GetandSetGenerator generator = new GetandSetGenerator();
		Converter converter = new Converter();
		try {
			String content = readfile.readTheFile("C:\\Users\\bhara\\eclipse-workspace\\POJO", "Employee.txt");
			// Creating a String array of read file and splitting it with line
			String[] strarr = content.split("\n");
			for (int i = 0; i < strarr.length; i++) {
				// Converting the array into variable names
				String an = converter.stringConverter(strarr[i]);
				// Writing the converted variable names to output file
				writefile.writeToFile("C:\\Users\\bhara\\eclipse-workspace\\POJO", "Output.txt", an);
				System.out.println(an);
			}
			for (int j = 1; j < strarr.length; j++) {
				// Generating Get and Set methods
				String b = generator.getstring(strarr[j]);
				// Writing the Get and Set methods to output file
				writefile.writeToFileGetAndSet("C:\\Users\\bhara\\eclipse-workspace\\POJO\\Output.txt", b);
				System.out.println(b);
			}
		} catch (IOException ex) {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
