package com.jiekebo.scjp;

public class Ouch {
	static int ouch = 7;
	public static void main(String[] args) {
		new Ouch().go(ouch);
		System.out.println(" " + ouch);
	}
	void go(int ouch) {
		ouch++;
		for(int nouch = 3; ouch < 6; ouch++)
			;
		System.out.println(" " + ouch);
	}
}
