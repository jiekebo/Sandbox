package com.jiekebo.Triangle;

/**
 * Triangle class
 * @author jiekebo
 *
 */
public class Triangle {
	
	protected enum Types {SCALENE, ISOSCELES, EQUILATERAL, ERROR}  
	private int a;
	private int b;
	private int c;
	
	/**
	 * Empty constructor, remember to set private members
	 */
	public Triangle() {}
	
	/**
	 * Creates a Triangle with lengths according to input
	 * @param a Length of side a
	 * @param b Length of side b
	 * @param c Length of side c
	 */
	public Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * Determines what type of triangle has been constructed
	 * @return <code>Types.ERROR</code> if input is not a triangle<br>
	 * <code>Types.SCALENE</code> if all sides are unequal<br>
	 * <code>Types.ISOSCELES</code> if two sides are equal<br>
	 * <code>Types.EQUILATERAL</code> if all sides are equal<br>
	 */
	public Types determineTriangleType(){
		// If two sides are smaller or equal to a third side, it is not a triangle
		if(a + b <= c || b + c <= a || a + c <= b)
			return Types.ERROR;
		// Triangle with all sides equal
		if(a == b && a == c)
			return Types.EQUILATERAL;
		// Triangle with (at least) two sides equal
		if(a == b || a == c || b == c)
			return Types.ISOSCELES;
		// Triangle with all sides unequal
		return Types.SCALENE;
	}

	// Generated getters and setters
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
}
