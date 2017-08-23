package com.tip14.czwords.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLPageConnector {

	private static final String CONNECTION_URL = "https://slovnik.seznam.cz/cz-ru/?q=";

	/**
	 * Returns Document in HTML from slovnik.seznam.cz service 
	 * with specified word to translate in URL
	 * 
	 * @param wordToTranslate word that need to be translated
	 * @return Document document at the specified url connection
	 */
	public static Document getDocument(String wordToTranslate) {
		try {
			return Jsoup.connect(CONNECTION_URL + wordToTranslate).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
