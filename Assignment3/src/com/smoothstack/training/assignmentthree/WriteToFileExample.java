package com.smoothstack.training.assignmentthree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is a class which writes data into files. SS April 2020
 * 
 * @author ppradhan
 */
public class WriteToFileExample {

	/**
	 * Method to demonstrate Write File.
	 * 
	 * @param args
	 */
	
	
	public static void writeAuthor(List<String> lines) {
		try {
			Files.write(Paths.get("resources/outputfiles/author.txt"), (lines));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to write data to File");
		}
		
	}
	public static void writeBook(List<String> lines) {
		try {
			Files.write(Paths.get("resources/outputfiles/books.txt"), (lines));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to write data to File");
		}
	}
	public static void writePublisher(List<String> lines) {
		try {
			Files.write(Paths.get("resources/outputfiles/publisher.txt"), (lines));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to write data to File");
		}
	}
}