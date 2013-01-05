package com.jiekebo.HashSet;

import java.util.Iterator;

import junit.framework.TestCase;

import org.junit.Test;


public class HashSetTest extends TestCase {

	private HashSet hashSet;
	
	public HashSetTest(String name) {
		super(name);
		hashSet = new HashSet();
	}
	
	@Test
	public void testAdd() {
		assertTrue(hashSet.add("Test"));
		assertFalse(hashSet.add("Test"));		
	}
	
	@Test
	public void testRemove() {
		hashSet.add("Test");
		hashSet.add("Another test");
		assertTrue((Boolean) hashSet.remove("Test"));
		assertFalse(hashSet.contains("Test"));
	}
	
	@Test
	public void testSize() {
		hashSet.add("Testing");
		hashSet.add("the");
		hashSet.add("Size");
		hashSet.add("command");
		assertEquals(hashSet.size(),4);
	}
	
	@Test
	public void testContains() {
		hashSet.add("Test");
		assertTrue(hashSet.contains("Test"));
		assertFalse(hashSet.contains("Not there"));
	}
	
	@Test
	public void testClear() {
		hashSet.add("Test");
		hashSet.clear();
		assertEquals(hashSet.size(), 0);
	}
	
	@Test
	public void testIsEmpty(){
		hashSet.add("Test");
		hashSet.clear();
		assertEquals(0, hashSet.size());
	}

	@Test
	public void testIterator() {
		hashSet.add("Testing ");
		hashSet.add("the ");
		hashSet.add("iterator");
		Iterator<Object> it = hashSet.iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		assertEquals("Testing the iterator", sb.toString());
	}
	
	@Test
	public void testClone() {
		hashSet.add("Test");
		HashSet anotherHashSet = hashSet.clone();
		assertTrue(hashSet.equals(anotherHashSet));
	}
	
	@Test
	public void testToString() {
		hashSet.add(new String("Hello "));
		hashSet.add(new String("World!"));
		assertEquals("{Hello ,World!}", hashSet.toString());
	}
	
}
