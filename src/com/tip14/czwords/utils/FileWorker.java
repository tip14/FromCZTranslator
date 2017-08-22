package com.tip14.czwords.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileWorker {

	private static final String FILE_NAME = "translations.txt";
	private File file = new File(FILE_NAME);

	public void readFileToConsole(File file) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));) {
			boolean isFileHasText = true;
			int letter = 0;
			while (isFileHasText) {
				letter = br.read();
				if (letter == -1) {
					isFileHasText = false;
				} else {
					System.out.print((char) letter);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeToFile(String... strings) {

		try (FileWriter fileWriter = new FileWriter(file, true)) {
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			//PrintWriter out = new PrintWriter(bw));
			
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

	public void readByLine(File file) {
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));) {

			boolean isFileHasText = true;
			int letter = 0;
			while (isFileHasText) {
				letter = br.read();
				if (letter == -1) {
					isFileHasText = false;
				} else {
					System.out.print((char) letter);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPathToFile() {

		return file.getAbsolutePath();

	}

	public BufferedReader getBufferedReader(File file) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			return br;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
