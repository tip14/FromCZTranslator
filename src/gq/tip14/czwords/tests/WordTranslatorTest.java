package gq.tip14.czwords.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gq.tip14.czwords.translators.WordTranslator;

public class WordTranslatorTest {

	WordTranslator wt = new WordTranslator();
	String word;
	String translatedWord;

	@Test
	public void normalWordTranslation() {
		word = "ahoj";
		translatedWord = wt.translateWord(word).substring(0, 5);
		assertEquals("hello", translatedWord);
	}

	@Test
	public void nullTranslation() {
		translatedWord = wt.translateWord(null);
		assertEquals("there is no word to translate", translatedWord);
	}

	@Test
	public void oneLetterTranslation() {
		word = "g";
		translatedWord = wt.translateWord(word);
		assertEquals("translations are unavaible", translatedWord);
	}

	@Test
	public void lettersSequentTranslation() {
		word = "wfegeaberg";
		translatedWord = wt.translateWord(word);
		assertEquals("translations are unavaible", translatedWord);
	}

	@Test
	public void symbolsTranslation() {
		word = "/$";
		translatedWord = wt.translateWord(word);
		assertEquals("translations are unavaible", translatedWord);
	}

	@Test
	public void wordsWithSpaceTranslation() {
		word = "ahoj kamo";
		translatedWord = wt.translateWord(word);
		assertEquals("translations are unavaible", translatedWord);
	}

	@Test
	public void numberTranslation() {
		word = "8";
		translatedWord = wt.translateWord(word);
		assertEquals("translations are unavaible", translatedWord);
	}

}
