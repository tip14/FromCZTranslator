package com.tip14.czwords.utils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLPageParser {

	private Document doc;
	private Element translationsBlock;
	private Elements translatedWords;
	private StringBuilder translatedWordsString = new StringBuilder();

	public String getTranslations(String wordToTranslate) {
		doc = HTMLPageConnector.getDocument(wordToTranslate);
		translatedWordsString.setLength(0);
		translationsBlock = doc.getElementById("fastMeanings");
		translatedWords = translationsBlock.getElementsByTag("a");

		for (Element translatedWord : translatedWords) {
			if (translatedWords.size() == translatedWords.indexOf(translatedWord) + 1) {
				translatedWordsString.append(translatedWord.text() + ";");
			} else {
				translatedWordsString.append(translatedWord.text() + ", ");
			}
		}

		return translatedWordsString.toString();

	}

}
