package com.jiekebo.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabeledStatementTest {

	@Test
	public void testRegex() {
		String query = "SELECT * FROM test WHERE name = :name AND age = :age";
		LabeledStatement stm = new LabeledStatement(query);
		assertEquals(2, stm.getBinds());
	}
	
	@Test
	public void testReplacement() {
		String query = "SELECT * FROM test WHERE name = :name AND age = :age";
		LabeledStatement stm = new LabeledStatement(query);
		assertEquals("SELECT * FROM test WHERE name = ? AND age = ?", stm.getPreparedStatement());
	}

	@Test
	public void testInt() {
		String query = "SELECT * FROM test WHERE name = :name AND age = :age";
		LabeledStatement stm = new LabeledStatement(query);
		assertEquals(2, stm.getLabelPosition().get("age"));
	}
	
}