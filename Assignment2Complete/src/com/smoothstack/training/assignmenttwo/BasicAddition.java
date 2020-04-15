/* Jeremy Didier
 * 4/15/20
 * Smoothstack Assignment 2
 */

package com.smoothstack.training.assignmenttwo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicAddition {

	public void doAddition() {
		System.out.println("Starting Addition Module: ");
		try (Scanner scan = new Scanner(System.in)) {
			ArrayList<Integer> array = new ArrayList<Integer>();
			Integer sum = 0;
			for (int i = 0; i < 5; i++) {
				System.out.println("Please input an integer value: ");
				array.add(scan.nextInt());
				//Create arraylist, input 5 values one at a time, catch non-integer values
			}
			for (Integer i : array) {
				sum += i;
			}
			System.out.println("The sum is: " + sum);
		} 
		catch (InputMismatchException e) {
			System.err.printf("Invalid input." + "%n" + "Please input one integer at a time.");
			return;
			
			//Catch non-integer values, move on to other functions
		}
	}
}
