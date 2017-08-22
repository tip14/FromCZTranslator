package com.tip14.czwords.translators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import com.tip14.czwords.utils.FileWorker;

public class FileTranslator extends WordTranslator {

	private FileWorker fw = new FileWorker();
	private BufferedReader br;

	public void translateFileToConsole(File file) {

		br = fw.getBufferedReader(file);

		String word = null;
		String translatedWord = null;

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
			System.out.println(translatedWord);
		}

	}

	public void translateFileToFile(File file) {
		br = fw.getBufferedReader(file);

		String word = null;
		String translatedWord = null;

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
			fw.writeToFile(translatedWord);
			
		}

	}

}
