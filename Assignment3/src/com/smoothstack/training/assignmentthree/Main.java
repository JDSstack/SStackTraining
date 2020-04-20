//Jeremy Didier
//4-20-20
//Smoothstack Assignment 3

package com.smoothstack.training.assignmentthree;

import java.util.Map;
import java.util.TreeMap;

public class Main {
	
	//TreeMaps automatically sort by compareTo(), making them preferable here
	protected static Map<Integer, Author> myAuthorMap = new TreeMap<>();
	protected static Map<Integer, Books> myBooksMap = new TreeMap<>();
	protected static Map<Integer, Publisher> myPublishersMap = new TreeMap<>();


	public static void main(String[] args) {
		FileReaderService.prepTables(myAuthorMap, myBooksMap, myPublishersMap);
		//myAuthorMap.forEach((key,value) -> System.out.println(key + " = " + value+" name: "+ key.getAuthorName()));
		@SuppressWarnings("unused")
		MainMenu menu = new MainMenu(myAuthorMap, myBooksMap, myPublishersMap);

	}

}
