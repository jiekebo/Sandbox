package com.jiekebo.scjp;

class MainConstructor {
	public MainConstructor(int x) {
		
	}
}

public class ConstructorTest extends MainConstructor {

	public ConstructorTest() {
		this(4);
	}
	
	public ConstructorTest(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

}