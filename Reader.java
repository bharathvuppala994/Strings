package com.siri.pojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	public String readTheFile(String path, String filename) throws Exception {
		BufferedReader bufreader = null;
		try {
			FileReader filereader = new FileReader(path + "\\" + filename);
			bufreader = new BufferedReader(filereader);
			String line = null;
			StringBuilder builder = new StringBuilder();
			while ((line = bufreader.readLine()) != null) {
				builder.append(line + "\n");
			}
			return builder.toString();
		} catch (Exception e) {
			System.out.println("READ: Invalid data type");
			throw new IOException(e.getMessage());
		} finally {
			bufreader.close();
		}

	}

}
