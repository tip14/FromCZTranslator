package gq.tip14.czwords.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLPageParser {

	private Document doc;
	private Element translationsBlock;
	private Elements translatedWords;
	private StringBuilder translatedWordsString = new StringBuilder();
	
	private static final String CONNECTION_URL = "https://slovnik.seznam.cz/cz-en/?q=";
	private static final String ERROR_FETCHING_URL = "Error fetching URL";
	private static final String FAST_MEANINGS = "fastMeanings";
	private static final String TAG_A = "a";
	private static final String SEMICOLON = ";";
	private static final String COMA = ",";
	private static final String TRANSLATIONS_ARE_UNAVAIBLE = "Translations are unavaible";	

	/**
	 * Returns Document in HTML from slovnik.seznam.cz service with specified
	 * word to translate in URL
	 * 
	 * @param wordToTranslate word that need to be translated
	 * @return Document document at the specified url connection
	 */
	public static Document getDocument(String wordToTranslate) {
																
		try {
			return Jsoup.connect(CONNECTION_URL + wordToTranslate).get();
		} catch (IOException e1) {
			System.out.println(ERROR_FETCHING_URL);
		}
		return null;

	}

	/**
	 * Method gets page from {@link HTMLPageConnector} and parse it for
	 * searching available translations of the specified word. Returns all
	 * available translations with formatting like String.
	 * 
	 * @param wordToTranslate
	 *            word that need to be translated
	 * @return String possible translation in String
	 */
	public String getTranslations(String wordToTranslate) {
		doc = getDocument(wordToTranslate);
		translatedWordsString.setLength(0);

		if (doc.getElementById(FAST_MEANINGS) != null) {
			translationsBlock = doc.getElementById(FAST_MEANINGS);
			translatedWords = translationsBlock.getElementsByTag(TAG_A);

			for (Element translatedWord : translatedWords) {

				if (translatedWords.size() == translatedWords.indexOf(translatedWord) + 1) {
					translatedWordsString.append(translatedWord.text() + SEMICOLON);
				} else {
					translatedWordsString.append(translatedWord.text() + COMA);
				}
			}

			return translatedWordsString.toString();
		}

		return TRANSLATIONS_ARE_UNAVAIBLE;

	}

}
