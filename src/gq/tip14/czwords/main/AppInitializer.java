package gq.tip14.czwords.main;

import java.util.Scanner;

import gq.tip14.czwords.translators.FileTranslator;
import gq.tip14.czwords.translators.WordTranslator;

public class AppInitializer {

	private Scanner scn = new Scanner(System.in);
	private FileTranslator ft;
	private WordTranslator wt;
	private String delimiter = null;
	private boolean enableConsole = false;

	private static final String TRANSLATE_WORD = "[w] - translate word";
	private static final String TRANSLATE_FILE = "[f] - translate file";
	private static final String EXIT = "[e] - exit";
	private static final String COMMAND_W = "w";
	private static final String COMMAND_F = "f";
	private static final String COMMAND_E = "e";
	private static final String INVALID_COMMAND = "invalid command!";
	private static final String ENTER_CZ_WORD = "Enter cz-word to translate: ";
	private static final String SEMICOLON = ";";
	

	public void initApp() {
		System.out.println(TRANSLATE_WORD);
		System.out.println(TRANSLATE_FILE);
		System.out.println(EXIT);
		
		while (true) {
			switch (scn.next()) {
			case COMMAND_W:
				initWordTranslator();
				break;
			case COMMAND_F:
				initFileTranslator();
				break;
			case COMMAND_E:
				System.exit(0);
				break;
			default:
				System.out.println(INVALID_COMMAND);
			}
		}
	}

	public void initApp(String... args) {
		if (args.length != 0) {
			
			if(args.length >= 2){
				delimiter = args[1];
			}
			if (args.length == 3 && args[2]=="c"){
				enableConsole = true;
				System.out.println(args);
			}
			
			switch (args[0]) {
			case COMMAND_F:
				initFileTranslator();
				break;
			case COMMAND_W:
				initWordTranslator();
				break;
			default:
				delimiter = SEMICOLON;
				initApp();
			}
			
		} else {
			initApp();
		}

	}

	private void initFileTranslator() {
		ft = new FileTranslator();
		ft.translateFile(delimiter, enableConsole);
		System.exit(0);

	}

	private void initWordTranslator() {
		wt = new WordTranslator();
		System.out.println(ENTER_CZ_WORD);
		String translatedWord = wt.translateWord(scn.next());
		System.out.println(translatedWord);
		System.exit(0);
	}
}
