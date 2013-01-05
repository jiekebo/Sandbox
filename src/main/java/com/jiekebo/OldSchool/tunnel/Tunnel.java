package com.jiekebo.OldSchool.tunnel;

import javax.swing.JFrame;

public class Tunnel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TunnelCanvas tunnelCanvas = new TunnelCanvas();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.getContentPane().add(tunnelCanvas);
	}

}
