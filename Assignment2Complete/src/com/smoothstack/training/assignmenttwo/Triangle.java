/* Jeremy Didier
 * 4/15/20
 * Smoothstack Assignment 2
 */

package com.smoothstack.training.assignmenttwo;

public class Triangle implements Shape{

	private int base;
	private int height;
	
	public Triangle(int base, int height) {
		this.height = height;
		this.base = base;
	}
	
	public float calculateArea() {
		float area = (base*height)/2;
		return area;
	}

	
	public void display() {
		System.out.printf("The size of the triangle's base is " + base + " , and the height is "
				+ height + "%n The area of the rectangle is: " + calculateArea() + "%n");
		
	}

}