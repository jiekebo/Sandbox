package com.jiekebo.MongoTest;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoTest {
	
	public MongoTest() {
		try {
			Mongo mn = new Mongo("127.0.0.1");
			DB testDB = mn.getDB("test");
			DBCollection things = testDB.getCollection("things");
			BasicDBObject test = new BasicDBObject();
			test.put("a", "2");
			test.put("b", "26");
			things.insert(test);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block$
			e.printStackTrace();
		}
	}
}
