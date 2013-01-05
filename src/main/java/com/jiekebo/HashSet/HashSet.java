package com.jiekebo.HashSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * HashSet class
 * @author jiekebo
 *
 */
public class HashSet extends HashMap<Integer, Object> {

	private static final long serialVersionUID = 1L;
	private int key = 0;
	
	/**
	 * Constructs a HashSet based on a HashMap, using the attribute that the
	 * HashMap always will be in sorted order according to the keys. Here the
	 * keys are not visible to user, but are used to keep the order in which
	 * Objects are added to the HashSet.
	 */
	public HashSet() {
		super();
	}
	
	/**
	 * Adds an object to the HashSet. A requirement of the set is that no
	 * duplicates can exist. No guarantee of the order of objects can be given.
	 * @param o Object to be inserted.
	 * @return True if Object has been inserted, False of the object already
	 * exists in the HashSet.
	 */
	public boolean add(Object o) {
		if(super.containsValue(o))
			return false;
		super.put(key, o);
		key++;
		return true;
	}
	
	/**
	 * Clears the HashSet
	 */
	public void clear() {
		super.clear();
	}
	
	/**
	 * Performs a shallow copy of the HashSet. Values are not cloned.
	 */
	public HashSet clone() {
		HashSet hashSet = this;
		return hashSet;
	}
	
	/**
	 * Returns true if the Object exists in the HashSet
	 * @param o Object to see if exists in the HashSet
	 * @return True if the HashSet contains the Object
	 */
	public boolean contains(Object o) {
		return super.containsValue(o);
	}
	
	/**
	 * If the HashSet is empty this is true
	 */
	public boolean isEmpty() {
		if(super.size() == 0)
			return true;
		return false;
	}
	
	/**
	 * Iterator to iterate over the values in the HashSet
	 * @return Iterator containing the values of the HashSet
	 */
	public Iterator<Object> iterator() {
		return super.values().iterator();
	}
	
	/**
	 * Remove an Object from the HashSet by finding the value's corresponding
	 * key in the underlying HashMap.
	 */
	public Object remove(Object o) {
		if(!super.containsValue(o))
			return false;
		Set<Entry<Integer, Object>> entries = super.entrySet();
		Integer key = null;
		for (Entry<Integer, Object> entry : entries) {
			if(entry.getValue().equals(o)) {
				key = entry.getKey();
			}
		}
		super.remove(key);
		return true;
	}
	
	/**
	 * Get the size of the HashSet
	 */
	public int size() {
		return super.size();
	}
	
	/**
	 * Print a string of the contents of the HashSet. Will use the Objects'
	 * default toString method to print.
	 */
	public String toString() {
		Iterator<Object> iterator = super.values().iterator();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			sb.append(object.toString() + ",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}
	
}
