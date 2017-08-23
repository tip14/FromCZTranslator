package com.tip14.czwords.translators;

import com.tip14.czwords.utils.HTMLPageParser;

public class WordTranslator {

	private static final HTMLPageParser HTML_PAGE_PARSER = new HTMLPageParser();

	public String translateWord(String wordToTranslate) {

		return HTML_PAGE_PARSER.getTranslations(wordToTranslate);
	}

}
