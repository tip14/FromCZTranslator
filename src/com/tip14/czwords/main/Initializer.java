package com.tip14.czwords.main;

import java.util.Scanner;

import com.tip14.czwords.translators.FileTranslator;
import com.tip14.czwords.translators.WordTranslator;

public class Initializer {

	Scanner scn = new Scanner(System.in);
	FileTranslator ft;
	WordTranslator wt;

	public void initMenu() {
		System.out.println("[w] - for translation one word");
		System.out.println("[f] - for translation whole file");
		System.out.println("[e] - exit");
		while (true) {
			System.out.println("your choice:");
			switch (scn.next()) {
			case "w":
				initWordTranslator();
				break;
			case "f":
				initFileTranslator();
				break;
			case "e":
				System.exit(0);
				break;
			}
		}
	}

	public void initFileTranslator() {
		System.out.println("Enter path to file with words:");
		String fileToTranslatingPath = scn.next();
		System.out.println("Enter path to file to translate in:");
		String pathToTranslatedFile = scn.next();
		System.out.println("Enter delimiters:");
		String delimiter = scn.next();

		ft = new FileTranslator(fileToTranslatingPath, pathToTranslatedFile, delimiter);
		ft.translateFile();
	}

	public void initWordTranslator() {
		wt = new WordTranslator();
		System.out.println("Enter cz-word to translate: ");
		String translatedWord = wt.translate(scn.next());
		System.out.println(translatedWord);
	}
}
