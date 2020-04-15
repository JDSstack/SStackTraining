/* Jeremy Didier
 * 4/15/20
 * Smoothstack Assignment 2
 */

package com.smoothstack.training.assignmenttwo;

public class Square implements Shape{
	private int side;
	
	public Square(int side) {
		this.side = side;
	}
	
	public float calculateArea() {
		float area = side*side;
		return area;
	}

	
	public void display() {
		System.out.printf("The length of each side of the square is: " + side 
				+ "%n The area of the square is: " + calculateArea() +"%n");
		
	}

}
