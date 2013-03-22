package com.jiekebo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamedBindPreparedStatement {
	
	private static final Pattern pattern = Pattern.compile("[:]{1}[a-zA-Z]*", Pattern.CASE_INSENSITIVE);
	private int binds = 0;
	private String query;
	
	public NamedBindPreparedStatement(String query) {
		this.query = query;
		
		Matcher matcher = pattern.matcher(query);
		
		while(matcher.find()) {
			binds++;
		}
	}
	
	public int setInt(String bind, int value) {
		int position = 0;
		
		Matcher matcher = pattern.matcher(query);
		
		while(matcher.find()) {
			position++;
			String match = matcher.group();
			if (match.substring(1).equals(bind)) {
				return position;
			}
				
		}
		return 0;
	}

	public void setString(String bind, String value) {
		// TODO Auto-generated method stub
		
	}
	
	public int getBinds() {
		return binds;
	}

	public void setBinds(int binds) {
		this.binds = binds;
	}

	private void test() {
		try {
			Connection test = null;
			PreparedStatement testStatement = test.prepareStatement("SELECT * FROM test WHERE test_parameter = ?");
//			testStatement.setString(parameterIndex, x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
}
