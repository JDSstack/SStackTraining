/* Jeremy Didier
 * 4/15/20
 * Smoothstack Assignment 2
 */

package com.smoothstack.training.assignmenttwo;

public class ArrayCrawler {
	
	public ArrayCrawler() {
				
	}
	
	public void crawl(int[][] array) {
		System.out.println("Starting Array Crawl");
		int maxValue = array[0][0];
		int maxI = 0;
		int maxJ = 0;
		
		//Initialize everything to 0, loop through array, record max values
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > maxValue) {
					maxValue = array[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}
		
		System.out.printf("The highest value in the array is: " + maxValue
				+ "%n Its position is: "+maxI+","+maxJ);
	}
	
}
