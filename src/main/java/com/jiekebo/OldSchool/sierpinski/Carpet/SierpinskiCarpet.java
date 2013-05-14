
package com.jiekebo.OldSchool.sierpinski.Carpet;
import java.awt.*;
import java.applet.*;
 
public class SierpinskiCarpet extends Applet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1984149791931080329L;
	private Graphics g=null;
    private int d0=729; // 3^6
 
    public void init() {
        g=getGraphics();
        resize(d0,d0);
    }
 
    public void paint(Graphics g) {
        //  start recursion:
        this.g = g;
        drawSierpinskiCarpet ( 0, 0, getWidth(), getHeight() );
    }
 
    private void drawSierpinskiCarpet(int xTL, int yTL, int width, int height) {
        if (width>2 && height>2) {
            int w=width/3, h=height/3;
            g.fillRect ( xTL+w, yTL+h, w, h );
            for (int k=0;k<9;k++) if (k!=4) {
                int i=k/3, j=k%3;
                drawSierpinskiCarpet ( xTL+i*w, yTL+j*h, w, h ); // recursion
            }
        }
    }
}