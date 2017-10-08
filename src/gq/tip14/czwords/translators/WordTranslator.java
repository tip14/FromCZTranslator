package gq.tip14.czwords.translators;

import gq.tip14.czwords.utils.HTMLPageParser;

public class WordTranslator {

	private static final HTMLPageParser HTML_PAGE_PARSER = new HTMLPageParser();
	private static final String NO_WORD_TO_TRANSLATE = "no word to translate";
	private static final String URL_SPACE = "%22";
	private static final String SPACE = " ";

	public String translateWord(String wordToTranslate) {

		if (wordToTranslate != null) {

			return HTML_PAGE_PARSER.getTranslations(wordToTranslate.replace(SPACE, URL_SPACE));

		} else {

			return NO_WORD_TO_TRANSLATE;

		}

	}

}
