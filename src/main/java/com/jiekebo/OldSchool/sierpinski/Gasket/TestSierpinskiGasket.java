package com.jiekebo.OldSchool.sierpinski.Gasket;

/* TestSierpinskiGasket
 *
 * Test the Sierpinski gasket class.
 *
 * Bruce M. Bolden
 * April 4, 2001
 */

import java.awt.Graphics;

import javax.swing.JFrame;

public class TestSierpinskiGasket extends JFrame
{
   static SierpinskiGasket sg;


   public static void main( String args[] )
   {
       final int WINDOW_SIZE = 600;

       TestSierpinskiGasket f = new TestSierpinskiGasket();

       sg = new SierpinskiGasket( f.getBackground(), 
                                  WINDOW_SIZE, WINDOW_SIZE );

       f.resize( WINDOW_SIZE, WINDOW_SIZE );
       f.show();
   }


   public void paint( Graphics g )
   {
       sg.drawSierpinskiGasket( g );
   }
}
