package gq.tip14.czwords.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileUtil {

	private BufferedWriter bufferedWriter = null;

	public void writeOutput(File file, String word, boolean consoleEnabled) {

		try (FileWriter fileWriter = new FileWriter(file, true)) {

			if (!consoleEnabled) {
				bufferedWriter = new BufferedWriter(fileWriter);
			} else {
				bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
			}

			bufferedWriter.append(word);
			bufferedWriter.newLine();
			bufferedWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BufferedReader getBufferedReader(File file) {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			return br;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public File createFile(String fileName) {

		File someFile = new File(fileName);

		try {
			if (someFile.createNewFile()) {
				return someFile;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return someFile;

	}

}
