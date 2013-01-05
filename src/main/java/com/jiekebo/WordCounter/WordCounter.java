package com.jiekebo.WordCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Word counter class
 * @author jiekebo
 *
 */
public class WordCounter {

	private HashMap<String, Integer> words = new HashMap<String, Integer>();
	private static final Comparator<Map.Entry<String, Integer>> frequencyComparator = new FrequencyComparator();

	/**
	 * Word counter constructor
	 */
	public WordCounter() {
		words = new HashMap<String, Integer>();
	}
	
	/**
	 * Word counter which uses the Scanner class' regexp facility to iterate
	 * through a document, counting each word and adding them to a HashMap.
	 * If the word exists the value in the HashMap for that word is incremented.
	 * @param path Location of the text file
	 * @throws FileNotFoundException Thrown if file is not found 
	 */
	public void countWords(File path) throws FileNotFoundException {
		Scanner scanner = new Scanner(path);
		// Regexp delimiting on anything not containing letters
		scanner.useDelimiter("[^A-Za-z]+");
		
		// Scan the whole text word by word and put them in the HashMap
		while(scanner.hasNext()) {
			String word = scanner.next();
			word = word.toLowerCase();
			// If word occurred before this is not null
			Integer count = words.get(word);
			if(count == null) {
				words.put(word, new Integer(1));
			} else {
				words.put(word, ++count);
			}
		}
		scanner.close();
	}
	
	/**
	 * Prints list of top 10 words sorted by occurrence.
	 */
	public void printResults() {
		// Convert to ArrayList containing the map
		ArrayList<Map.Entry<String,Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(words.entrySet());
		// To be able to sort for frequencies with the comparator defined in FrequencyComparator.java
		Collections.sort(entries, frequencyComparator);
		// Print top 10
		for (int i = 0; i < (entries.size()<10?entries.size():10); i++) {
			Entry<String, Integer> entry = entries.get(i);
			System.out.println("Word: " + entry.getKey() + "\tFrequency: " + entry.getValue());
		}
	}
	
	/**
	 * Getter for the HashMap containing words and their frequencies.
	 * @return HashMap of key type String and value type Integer
	 */
	public HashMap<String, Integer> getWords() {
		return words;
	}
	
}
