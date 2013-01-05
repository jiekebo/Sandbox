package com.jiekebo.Triangle;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test of the triangle class
 * @author jiekebo
 *
 */
public class TriangleTest extends TestCase {
	
	public TriangleTest(String name) {
		super(name);
	}

	@Test
	public void testScaleneTriangle() {
		int a = 2;
		int b = 4;
		int c = 3;
		Triangle triangle = new Triangle(a, b, c);
		assertEquals(Triangle.Types.SCALENE, triangle.determineTriangleType());
	}

	@Test
	public void testIsoscelesTriangle() {
		int a = 5;
		int b = 5;
		int c = 9;
		Triangle triangle = new Triangle(a, b, c);
		assertEquals(Triangle.Types.ISOSCELES, triangle.determineTriangleType());
	}

	@Test
	public void testEquilateralTriangle() {
		int a = 10;
		int b = 10;
		int c = 10;
		Triangle triangle = new Triangle(a, b, c);
		assertEquals(Triangle.Types.EQUILATERAL, triangle.determineTriangleType());
	}

	@Test
	public void testErroneousTriangle() {
		int a = 10;
		int b = 1;
		int c = 1;
		Triangle triangle = new Triangle(a, b, c);
		assertEquals(Triangle.Types.ERROR, triangle.determineTriangleType());
	}
	
}
