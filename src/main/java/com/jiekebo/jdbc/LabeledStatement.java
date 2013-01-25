package com.jiekebo.jdbc;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabeledStatement {

	private static final Pattern pattern = Pattern.compile("[:]{1}[:a-zA-Z]*", Pattern.CASE_INSENSITIVE);
	private int binds = 0;
	private String originalQuery;
	private Map labelPosition = new HashMap();
	private String preparedStatement;
	private Connection connection;

	/**
	 * This class will convert a statement of the form <code>SELECT * FROM table WHERE column1 = :label1 AND column2 = :label2</code>
	 * with <code>SELECT * FROM table WHERE column1 = ? AND column2 = ?</code>. A map, <code>labelPositions</code>, containing the 
	 * correct position of parameters is created. This can be used to populate a PreparedStatement with arguments in the correct
	 * positions.
	 * @param originalQuery The original query with labels of the form <code>:label</code> instead of binds <code>?</code>.
	 */
	public LabeledStatement(String originalQuery) {
		this.originalQuery = originalQuery;
		this.connection = connection;

		Matcher matcher = pattern.matcher(originalQuery);

		while (matcher.find()) {
			binds++;
			labelPosition.put(matcher.group().substring(1), binds);
		}

		preparedStatement = matcher.replaceAll("?");
	}

	public int getBinds() {
		return binds;
	}

	public String getQuery() {
		return originalQuery;
	}

	public void setQuery(String query) {
		this.originalQuery = query;
	}

	public Map getLabelPosition() {
		return labelPosition;
	}

	public void setLabelPosition(Map labelPosition) {
		this.labelPosition = labelPosition;
	}

	public String getPreparedStatement() {
		return preparedStatement;
	}

}