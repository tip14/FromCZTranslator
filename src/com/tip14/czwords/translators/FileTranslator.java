package com.tip14.czwords.translators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import com.tip14.czwords.utils.FileUtil;

public class FileTranslator extends WordTranslator {

	private FileUtil fileUtil = new FileUtil();
	private BufferedReader br;
	private String wordsOnLine[] = null;
	private String translatedWord = null;
	private String word = null;
	private String line = null;

	public void translateFileToConsole(File file) {

		br = fileUtil.getBufferedReader(file);

		while (true) {
			try {
				String word = br.readLine();
				if (word == null)
					break;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			translatedWord = translateWord(word.trim());
			System.out.println(word + " - " + translatedWord);
		}

	}

	public void translateFileToConsole(File file, String delimiter) {

		br = fileUtil.getBufferedReader(file);

		while (true) {
			try {
				line = br.readLine();
				if (line == null)
					break;
				wordsOnLine = line.split(delimiter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (String word : wordsOnLine) {

				translatedWord = translateWord(word.trim());
				System.out.println(word + " - " + translatedWord);
			}

		}

	}

	public void translateFileToFile(File file) {
		br = fileUtil.getBufferedReader(file);

		while (true) {
			try {
				word = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (word == null)
				break;
			translatedWord = translateWord(word);
			fileUtil.writeToFile(word + " - " + translatedWord);

		}

	}

	public void translateFileToFile(File file, String delimiter) {
		br = fileUtil.getBufferedReader(file);

		while (true) {
			try {
				line = br.readLine();
				if (line == null)
					break;
				wordsOnLine = line.split(delimiter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (String word : wordsOnLine) {
				translatedWord = translateWord(word.trim());
				fileUtil.writeToFile(word + " - " + translatedWord);
			}

		}

	}

}
