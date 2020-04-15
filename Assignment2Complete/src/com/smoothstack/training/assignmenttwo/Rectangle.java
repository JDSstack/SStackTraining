/* Jeremy Didier
 * 4/15/20
 * Smoothstack Assignment 2
 */

package com.smoothstack.training.assignmenttwo;

public class Rectangle implements Shape{

	private int longS;
	private int wideS;
	
	public Rectangle(int longS, int wideS) {
		this.wideS = wideS;
		this.longS = longS;
	}
	
	public float calculateArea() {
		float area = longS*wideS;
		return area;
	}

	
	public void display() {
		System.out.printf("The lengths of each side of the rectangle are: " + longS + " , "
				+ wideS + "%n The area of the rectangle is: " + calculateArea() + "%n");
		
	}

}