package com.tip14.czwords.translators;

import com.tip14.czwords.utils.HTMLParser;

public class WordTranslator {
	
	private static final HTMLParser HTMLPARSER = new HTMLParser();

	public String translate(String wordToTranslate) {

		return HTMLPARSER.getTranslations(wordToTranslate);
	}
	
	
	
	
}
