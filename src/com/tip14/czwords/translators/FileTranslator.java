package com.tip14.czwords.translators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.tip14.czwords.exceptions.BackslashInPathException;
import com.tip14.czwords.exceptions.FileExistsException;
import com.tip14.czwords.exceptions.InvalidFilePathException;

public class FileTranslator {
	private File translatedWordsList;
	private Scanner scn;
	private FileWriter fileWriter;
	private String s;
	private String nextWordInFront;
	private String translatedWord;
	private WordTranslator wordTranslator = new WordTranslator();
	private String pathToFileWithWordsToTranslate;
	private String pathToFileWithTranslatedWords;
	private String delimiter;

	public FileTranslator(String pathToFileWithWordsToTranslate, String pathToFileWithTranslatedWords,
			String delimiter) {

		try {
			if (pathCheck(pathToFileWithWordsToTranslate)) {
				this.pathToFileWithWordsToTranslate = pathToFileWithWordsToTranslate;
				this.pathToFileWithTranslatedWords = pathToFileWithTranslatedWords;
				this.delimiter = delimiter;
			}
		} catch (FileExistsException e) {
			System.out.println("FileWithWordsToTranslate doesn't exist!");
		} catch (InvalidFilePathException e) {
			System.out.println("It's directory, i need a file!");
		} catch (BackslashInPathException e) {
			System.out.println("Please, use only slashes in path");
		}

	}

	public void translateFile() {
		try {
			scn = new Scanner(new File(pathToFileWithWordsToTranslate));
			scn.useDelimiter(delimiter);

			translatedWordsList = new File(pathToFileWithTranslatedWords);
			fileWriter = new FileWriter(translatedWordsList);

			int wordCount = 0;
			while (scn.hasNext()) {
				nextWordInFront = scn.next();
				translatedWord = wordTranslator.translate(nextWordInFront);
				if (translatedWord != null) {
					++wordCount;
					s = wordCount + ". " + nextWordInFront + " — " + translatedWord + "\n";
					fileWriter.write(s);
					System.out.println(wordCount + " translated");
				}
			}
			fileWriter.flush();
			System.out.println("Translation is succesfully end");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException cathced");
		} catch (IOException e) {
			System.out.println("IOException catched");
		}

	}

	private boolean pathCheck(String path1)
			throws FileExistsException, InvalidFilePathException, BackslashInPathException {
		File fl1 = new File(path1);

		if (!fl1.exists()) {
			throw new FileExistsException();
		} else if (!fl1.isDirectory()) {
			throw new InvalidFilePathException();
		} else if (path1.contains("\\")) {
			throw new BackslashInPathException();
		}

		return true;
	}
}
