package com.jiekebo.WordCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import junit.framework.TestCase;

import org.junit.Test;

public class WordCounterTest extends TestCase {
	
	public WordCounterTest(String name) {
		super(name);
	}	
	
	/**
	 * Test word counter on a text where the occurrence of the word "to" is
	 * already found to be 17.
	 */
	@Test
	public void testCountWords(){
		try {
			WordCounter wordCounter = new WordCounter();
			wordCounter.countWords(new File("loremIpsum.txt"));
			HashMap<String,Integer> words = wordCounter.getWords();
			assertEquals(words.get("to"), new Integer(17));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
