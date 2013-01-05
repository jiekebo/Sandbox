package com.jiekebo.WordCounter;

import java.io.File;
import java.io.IOException;

public class WordCounterRun {

	public static void main(String[] args) {
		WordCounter wordCounter = new WordCounter();
		try {
			wordCounter.countWords(new File("loremIpsum.txt"));
			wordCounter.printResults();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
