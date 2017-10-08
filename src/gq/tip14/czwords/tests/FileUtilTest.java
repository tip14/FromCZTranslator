package gq.tip14.czwords.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import gq.tip14.czwords.utils.FileUtil;

public class FileUtilTest {
	
	FileUtil fu = new FileUtil();
	File myFile = new File("somefile.txt");
	
	@Test
	public void getBufferedReaderTest(){
		
		try {
			myFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = fu.getBufferedReader(myFile);
		FileReader fr = null;
		try {
			fr = new FileReader(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new BufferedReader(fr).getClass(), br.getClass());
	}
	
	@Test
	public void writeToFileTest(){
		String testString = "i'm test string 1!";
		fu.writeOutput(myFile, testString, false);
		String readString = null;
		try {
			readString = fu.getBufferedReader(new File("translations.txt")).readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(testString, readString);
	}

}
