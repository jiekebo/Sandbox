package com.jiekebo.OldSchool.sierpinski.Gasket;

/* SierpinskiGasket.java
 *
 * Create a Sierpinski gasket inside a given window.
 *
 * Bruce M. Bolden
 * April 4, 2001
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;


public class SierpinskiGasket
{
   static final int INSET = 80;        //  inset from window edges
   static final int MIN_POINTS = 2000; //  point to draw the gasket
   static final int POINT_SIZE = 3;    //  size of points <3 can be problmatic
   static final Random rng = new Random();  //  random number generator

   int nPoints;       // points used to display a gasket
   int windowSize;    // minimum of height and width
   Color background;

   /** Initialize background color and size of the
    *  Sierpinski gasket.
    */
   SierpinskiGasket( Color bgC, int h, int w )
   {
       nPoints = MIN_POINTS;
       background = bgC;
       windowSize = Math.min( h, w );  // minimum of height and width
   }


   /** Draw Sierpinski gasket using "nPoints" random points.
    */
   public void drawSierpinskiGasket( Graphics g )
   {
       Point v[] = new Point[3];   //  Vertices of the triangle
       v[0] = new Point(            INSET, windowSize-INSET );
       v[1] = new Point(     windowSize/2,      INSET       );
       v[2] = new Point( windowSize-INSET, windowSize-INSET );

       /*  Check points
       g.drawLine( v[0].x, v[0].y, v[1].x, v[1].y );
       g.drawLine( v[1].x, v[1].y, v[2].x, v[2].y );
       g.drawLine( v[2].x, v[2].y, v[0].x, v[0].y );
       for( int i = 0 ; i < 3 ; i++ )
       {
           System.out.print( "vertex[" + i + "]: " 
           System.out.println( v[i].x + ", " + v[i].y );
       }
       */

       int i, j;
       Point p = new Point( windowSize/2, INSET );

       g.setColor(Color.red);

       for( i = 0 ; i < nPoints ; i++ )
       {
           j = Math.abs(rng.nextInt()) % 3;

              //  new point
           p.x = (p.x + v[j].x)/2;
           p.y = (p.y + v[j].y)/2;

           //System.out.println( "p[" + i + "]: " + p.x + ", " + p.y );

           g.fillOval( p.x, p.y, POINT_SIZE, POINT_SIZE );
       }
   }
}