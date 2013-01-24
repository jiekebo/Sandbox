package com.jiekebo.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

public class NamedBindPreparedStatementTest {

	@Test
	public void testReplacement() {
		String query = "SELECT * FROM test WHERE name = :name AND age = :age";
		NamedBindPreparedStatement stm = new NamedBindPreparedStatement(query);
		assertEquals(2, stm.getBinds());
	}
	
	@Test
	public void testInt() {
		String query = "SELECT * FROM test WHERE name = :name AND age = :age";
		NamedBindPreparedStatement stm = new NamedBindPreparedStatement(query);
		int i = stm.setInt("age", 42);
		assertEquals(2, i);
//		String expectedQuery = "SELECT * FROM test WHERE name = :name AND age = 11";
//		assertEquals(expectedQuery, stm.getQuery());
	}
	
}
