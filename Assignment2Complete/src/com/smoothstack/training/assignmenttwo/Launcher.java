/* Jeremy Didier
 * 4/15/20
 * Smoothstack Assignment 2
 */

package com.smoothstack.training.assignmenttwo;

public class Launcher {

	public static void main(String[] args) {
		BasicAddition adder = new BasicAddition();
		adder.doAddition();
		System.out.println();
		
		ArrayCrawler crawler = new ArrayCrawler();
		//There was no specification as to how to get the array
		//, so I'm just initializing one here to save time
		int[][] twoDArray = {{3,9,12,5}, {1,5,7,22}};
		crawler.crawl(twoDArray);
		
		System.out.println();
		
		//Similarly to the array, just constructing with set values
		Square newSq = new Square(4);
		newSq.display();
		
		Rectangle newRc = new Rectangle(7,2);
		newRc.display();
		
		Circle newCr = new Circle(5);
		newCr.display();
		
		System.out.println();
		//4:51 edit: Identified a misunderstanding of the assignment requirements, added Triangle class
		
		Triangle newTr = new Triangle(10,7);
		newTr.display();

	}

}
