package com.tip14.czwords.translators;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WordTranslator {
	private Document doc = null;
	private Element translationsBlock = null;
	private Elements translatedWords = null;
	private StringBuilder translatedWordsString;

	public String translate(String wordToTranslate) {
		try {
			doc = Jsoup.connect("https://slovnik.seznam.cz/cz-ru/?q=" + wordToTranslate).get();

			translationsBlock = doc.getElementById("fastMeanings");
			translatedWords = translationsBlock.getElementsByTag("a");
			translatedWordsString = new StringBuilder();

			for (Element translatedWord : translatedWords) {
				if (translatedWords.size() == translatedWords.indexOf(translatedWord) + 1) {
					translatedWordsString.append(translatedWord.text() + ";");
				} else {
					translatedWordsString.append(translatedWord.text() + ", ");
				}
			}

			return translatedWordsString.toString();

		} catch (IOException e) {
			System.out.println("IOException catched");
		} catch (NullPointerException e) {
			System.out.println("NPE catched");
		}
		return null;
	}
}
