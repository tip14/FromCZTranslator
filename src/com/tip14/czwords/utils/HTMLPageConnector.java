package com.tip14.czwords.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLPageConnector {

	private static final String CONNECTION_URL = "https://slovnik.seznam.cz/cz-ru/?q=";

	public static Document getDocument(String wordToTranslate) {
		try {
			return Jsoup.connect(CONNECTION_URL + wordToTranslate).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
