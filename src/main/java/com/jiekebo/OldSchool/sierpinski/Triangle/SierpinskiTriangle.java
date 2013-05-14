package com.jiekebo.OldSchool.sierpinski.Triangle;

import java.awt.*;
import java.applet.*;

public class SierpinskiTriangle extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2223481420434974370L;
	private Graphics g = null;
	private int d0 = 640;
	
	public void init(){
		g = getGraphics();
		resize(d0,d0);
	}
	
	public void paint(Graphics g){
		this.g = g;
		g.drawLine(d0/2, 0, d0, d0);
		g.drawLine(d0/2, 0, 0, d0);
		g.drawLine(0, d0, d0, d0);
		
		g.drawLine(d0/4, d0/2, 3*(d0/4),d0/2);
		g.drawLine(d0/4, d0/2, d0/2, d0);
		g.drawLine(3*(d0/4), d0/2, d0/2, d0);
		
		g.drawLine(3*(d0/8), d0/4, 5*(d0/8),d0/4);
		g.drawLine(d0/4, d0/2, d0/2, d0);
		g.drawLine(3*(d0/4), d0/2, d0/2, d0);
	}
	
	
}
