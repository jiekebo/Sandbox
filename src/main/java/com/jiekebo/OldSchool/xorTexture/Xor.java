package com.jiekebo.OldSchool.xorTexture;

import javax.swing.JFrame;

public class Xor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XorCanvas xorCanvas = new XorCanvas();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.getContentPane().add(xorCanvas);
	}

}
