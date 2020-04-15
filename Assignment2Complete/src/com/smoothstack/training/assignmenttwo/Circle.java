/* Jeremy Didier
 * 4/15/20
 * Smoothstack Assignment 2
 */

package com.smoothstack.training.assignmenttwo;

public class Circle implements Shape{
	private int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	public float calculateArea() {
		float area = (float) ((radius*radius)*Math.PI);
		return area;
	}

	
	public void display() {
		System.out.printf("The length of the radius of the circle is: " + radius 
				+ "%n The area of the circle is: " + calculateArea() +"%n");
		
	}

}