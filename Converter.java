package com.siri.pojo;

import java.io.IOException;

public class Converter {
	String stringConverter(String str) throws Exception {
		try {
			if (str.startsWith("@")) {
				// Splitting @TABLE@:eMPloyEE_DeTailS with ":"
				String[] strsplit = str.split(":");
				// Converting eMPloyEE_DeTailS to Lowercase
				String classname = strsplit[1].toLowerCase();
				// Converting eMPloyEE_DeTailS to camelcase by splitting the string by "_" and
				// converting the first letter of both strings to Uppercase
				String[] camel = classname.split("_");
				String first = camel[0].substring(0, 1).toUpperCase().concat(camel[0].substring(1));
				String second = camel[1].substring(0, 1).toUpperCase().concat(camel[1].substring(1));
				String details = "public class ";
				// Appending "public class" and "{" for the class name
				return details.concat(first.concat(second).concat("\n{"));
			} else {
				String result = "";
				// Converting the variable names to Lower case and converting the input to
				// required datatype
				String lowercase = str.toLowerCase();
				if (lowercase.endsWith("varchar2")) {
					lowercase = lowercase.replace("varchar2", "String");
				} else if (lowercase.endsWith("char")) {
					lowercase = lowercase;
				} else if (lowercase.endsWith("number")) {
					lowercase = lowercase.replace("number", "int");
				} else if (lowercase.endsWith("date")) {
					lowercase = lowercase.replace("date", "Date");
				} else {
					System.out.println("unsupported data type, enter valid datatype");
					throw new IOException();
				}
				// Splitting the String with ":" and putting the datatype into the String
				int LengthofString = lowercase.length();
				int IndexofColon = lowercase.indexOf(":");
				String datatype = lowercase.substring(IndexofColon + 1, LengthofString);
				if (lowercase.contains("_")) {
					// Splitting the String into two different Strings and Converting the letter
					// after the "_" into capital letter
					int IndexofUnder = lowercase.indexOf("_");
					String firstpart = lowercase.substring(0, IndexofUnder);
					String secondpart = lowercase.substring(IndexofUnder + 1, IndexofUnder + 2).toUpperCase()
							.concat(lowercase.substring(IndexofUnder + 2, IndexofColon));
					// Appending "private" to the String i.e datatype and variable names
					result = "private " + datatype + " " + firstpart.concat(secondpart) + ";";
				} else
					result = "private " + datatype + " " + lowercase.substring(0, IndexofColon) + ";";
				return result;
			}
		} catch (Exception e) {
			System.out.println("Convert: Cannot convert given Data Type to a valid data type");
			throw new Exception(e.getMessage());
		}

	}
}
