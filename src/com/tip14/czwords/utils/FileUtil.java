package com.tip14.czwords.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

//TODO: check and change hardcoded variables
public class FileUtil {

	private static final String FILE_NAME = "translations.txt";
	private File file = new File(FILE_NAME);

	public void writeToFile(String... strings) {

		try (FileWriter fileWriter = new FileWriter(file, true)) {
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for (String s : strings) {
				bufferedWriter.append(s);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public File createFileWithTranslations(String fileName){
		return new File(fileName);
	}

	public String getPathToFile(File file) {

		return file.getAbsolutePath();

	}

	public BufferedReader getBufferedReader(File file) {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			return br;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
