package com.jiekebo.Bag;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface Bag extends Collection {
	
	/**
	 * 
	 * @param o
	 * @return
	 */
	int getCount(Object o);
	
	/**
	 * 
	 */
	boolean add(Object o);
	
	/**
	 * 
	 * @param o
	 * @param copies
	 * @return
	 */
	boolean add(Object o, int copies);
	
	/**
	 * 
	 */
	boolean remove(Object o);
	
	/**
	 * 
	 * @param o
	 * @param copies
	 * @return
	 */
	boolean remove(Object o, int copies);
	
	/**
	 * 
	 * @return
	 */
	Set uniqueSet();
	
	/**
	 * 
	 * @return  
	 */
	int size();
	
	/**
	 * 
	 */
	boolean containsAll(Collection collection);
	
	/**
	 * 
	 */
	boolean removeAll(Collection collection);
	
	/**
	 * 
	 */
	boolean retainAll(Collection collection);
	
	/**
	 * 
	 */
	Iterator iterator();
}
