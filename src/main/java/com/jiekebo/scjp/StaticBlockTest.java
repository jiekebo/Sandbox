package com.jiekebo.scjp;

public class StaticBlockTest {
	public static int x;

	static {
		int width = 10;
		int height = 5;
		x = width * height;
	}
	
	
	public static void main(String[] args) {
//		x = 10;
		System.out.println(x);
		String test = "test";
		char[] chartest = {2,3,4};
		for(final int i : chartest) {
			System.out.print(i);
		}
		System.out.println("");
		// Implicit widen
		byte testByte = 7;
		int byteTest = testByte;
		// Explicit narrow
		int intTest = 7;
		byte testInt = (byte) intTest;
		
		byte testByteResult = (byte) (testByte + intTest);
		System.out.println(testByteResult);
		
		// Short -> char test
		char testChar = 'b';
		short testShort = (short) testChar;
		System.out.println(testShort);
	}
}
