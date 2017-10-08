package gq.tip14.czwords.translators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import gq.tip14.czwords.utils.FileUtil;

public class FileTranslator extends WordTranslator {

	private static final String CZ_WORDS = "cz-words.txt";
	private static final String TRANSLATIONS = "translations.txt";
	private static final String FILE_WITH_TRANSLATIONS_IS_HERE = "File with translations is here ";
	
	private FileUtil fileUtil = new FileUtil();
	private File czWordsFile = fileUtil.createFile(CZ_WORDS);
	private File translatedWordsFile = fileUtil.createFile(TRANSLATIONS);
	private BufferedReader br = fileUtil.getBufferedReader(czWordsFile);
	private String wordsOnLine[] = new String[1];
	private String translatedWord = null;
	private String wordsLine = null;
	private String trimmedWord = null;

	public void translateFile(String delimiter, boolean consoleEnabled) {

		while (true) {
			try {

				wordsLine = br.readLine();

				if (wordsLine == null) {
					break;
				}

				if (delimiter != null) {
					wordsOnLine = wordsLine.trim().split(delimiter);
				} else {
					wordsOnLine[0] = wordsLine;
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

			for (String word : wordsOnLine) {
				trimmedWord = word.trim();
				translatedWord = translateWord(trimmedWord);
				fileUtil.writeOutput(translatedWordsFile, trimmedWord + " - " + translatedWord, consoleEnabled);
			}

		}

		if (!consoleEnabled) {
			System.out.println(FILE_WITH_TRANSLATIONS_IS_HERE + translatedWordsFile.getAbsolutePath());
		}
	}

}
