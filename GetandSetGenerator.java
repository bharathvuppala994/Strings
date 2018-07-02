package com.siri.pojo;

public class GetandSetGenerator {
	public String getstring(String genstr) throws Exception {
		String result1 = "";
		String getmethod = "get";
		String setmethod = "set";
		String instancevar = "";
		String LowerCase = genstr.toLowerCase();
		// Writing datatypes for get and set methods
		if (LowerCase.endsWith("varchar2")) {
			LowerCase = LowerCase.replace("varchar2", "String");
		} else if (LowerCase.endsWith("char")) {
			LowerCase = LowerCase;
		} else if (LowerCase.endsWith("number")) {
			LowerCase = LowerCase.replace("number", "int");
		} else if (LowerCase.endsWith("date")) {
			LowerCase = LowerCase.replace("date", "Date");
		} else {
			System.out.println("Cannot generate get and set methods for such Data Type.");
		}
		// Splitting the String by ":" and putting the datatype into the String
		int stringlength = LowerCase.length();
		int indexOfColon = LowerCase.indexOf(":");
		String dataType = LowerCase.substring(indexOfColon + 1, stringlength);
		// Writing Get and Set methods for variables having "_" and not having "_"
		if (LowerCase.contains("_")) {
			int indexOfUnderscore = LowerCase.indexOf("_");
			String BeforeUnderscore = LowerCase.substring(0, indexOfUnderscore);
			String AfterUnderscore = LowerCase.substring(indexOfUnderscore + 1, indexOfUnderscore + 2).toUpperCase()
					.concat(LowerCase.substring(indexOfUnderscore + 2, indexOfColon));
			instancevar = BeforeUnderscore.concat(AfterUnderscore);
			if (instancevar.startsWith("u")) {
				setmethod = "public void " + setmethod.concat(BeforeUnderscore).concat(AfterUnderscore) + "(" + dataType
						+ " " + BeforeUnderscore.concat(AfterUnderscore) + "){ \n" + "\t" + "this."
						+ BeforeUnderscore.concat(AfterUnderscore) + "=" + BeforeUnderscore.concat(AfterUnderscore)
						+ "; \n" + "}" + "\n}";
			} else {
				setmethod = "public void " + setmethod.concat(BeforeUnderscore).concat(AfterUnderscore) + "(" + dataType
						+ " " + BeforeUnderscore.concat(AfterUnderscore) + "){ \n" + "\t" + "this."
						+ BeforeUnderscore.concat(AfterUnderscore) + "=" + BeforeUnderscore.concat(AfterUnderscore)
						+ "; \n" + "}";
			}

			getmethod = "public " + dataType + " " + getmethod.concat(instancevar) + "(){ \n \t" + "return "
					+ BeforeUnderscore.concat(AfterUnderscore) + ";" + "\n } \n";
			return getmethod + setmethod;
		} else {
			try {
				instancevar = LowerCase.substring(0, indexOfColon);
				getmethod = "public " + dataType + " " + getmethod.concat(instancevar) + "(){ \n \t" + "return "
						+ instancevar + "; \n } \n";
				setmethod = "public void " + setmethod.concat(instancevar) + "(" + dataType + " " + instancevar
						+ "){ \n \t this." + instancevar + "=" + instancevar + "; \n } \n";
			} catch (Exception e) {
				throw new Exception("Cannot generate get and set methods for such Data Type.");
			}
			result1 = getmethod + setmethod;
		}
		return result1;

	}

}
