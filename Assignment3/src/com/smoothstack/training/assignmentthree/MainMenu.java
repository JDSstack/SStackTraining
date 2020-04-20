//Jeremy Didier
//4-19-20
//Smoothstack Assignment 3

package com.smoothstack.training.assignmentthree;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
	private int selection;
	private Scanner scanIn = new Scanner(System.in);
	Map<Integer, Author> myAuthorMap;
	Map<Integer, Books> myBooksMap;
	Map<Integer, Publisher> myPublishersMap;

	public MainMenu(Map<Integer, Author> myAuthorMap, Map<Integer, Books> myBooksMap,
			Map<Integer, Publisher> myPublishersMap) {

		this.myAuthorMap = myAuthorMap;
		this.myBooksMap = myBooksMap;
		this.myPublishersMap = myPublishersMap;
		generateMenu();
	}

	private void generateMenu() {
		System.out.printf("Library Main Menu %nPlease select from one of the following options:%n%n"
				+ "1. Authors %n2. Books%n3. Publishers%n4. Close Program%n%n");
		try {
			selection = scanIn.nextInt();
		} catch (InputMismatchException e) {
			System.out
					.printf("Invalid selection. Please input integers only for navigation. %nTerminating application.");
			return;
		}

		switch (selection) {
		case 1:
			authorSubMenu();
			break;
		case 2:
			bookSubMenu();
			break;
		case 3:
			publisherSubMenu();
			break;
		case 4:
			System.out.println("Closing Program.");
			System.exit(0);
		default:
			System.out.println("Invalid selection. Please choose one of the listed options.");
			generateMenu();
		}
	}

	private void authorSubMenu() {
		System.out.printf("Author Menu %nPlease select from one of the following options:%n%n"
				+ "1. Create %n2. Read%n3. Update%n4. Delete%n%n");

		try {
			selection = scanIn.nextInt();
		} catch (InputMismatchException e) {
			System.out
					.printf("Invalid selection. Please input integers only for navigation. %nTerminating application.");
			return;
		}
		
		scanIn.nextLine();

		switch (selection) {
		case 1:
			createAuthor(myAuthorMap);
			break;
		case 2:
			readAuthors(myAuthorMap);
			break;
		case 3:
			updateAuthors(myAuthorMap);
			break;
		case 4:
			deleteAuthor(myAuthorMap);
			break;
		default:
			System.out.println("Invalid selection. Please choose one of the listed options.");
			generateMenu();
		}
	}

	private void bookSubMenu() {
		System.out.printf("Book Menu %nPlease select from one of the following options:%n%n"
				+ "1. Create %n2. Read%n3. Update%n4. Delete%n%n");

		try {
			selection = scanIn.nextInt();
		} catch (InputMismatchException e) {
			System.out
					.printf("Invalid selection. Please input integers only for navigation. %nTerminating application.");
			return;
		}
		
		scanIn.nextLine();

		switch (selection) {
		case 1:
			createBook(myBooksMap);
			break;
		case 2:
			readBooks(myBooksMap);
			break;
		case 3:
			updateBooks(myBooksMap);
			break;
		case 4:
			deleteBook(myBooksMap);
			break;
		default:
			System.out.println("Invalid selection. Please choose one of the listed options.");
			generateMenu();
		}
	}

	private void publisherSubMenu() {
		System.out.printf("Publisher Menu %nPlease select from one of the following options:%n%n"
				+ "1. Create %n2. Read%n3. Update%n4. Delete%n%n");

		try {
			selection = scanIn.nextInt();
		} catch (InputMismatchException e) {
			System.out
					.printf("Invalid selection. Please input integers only for navigation. %nTerminating application.");
			return;
		}
		
		scanIn.nextLine();

		switch (selection) {
		case 1:
			createPub(myPublishersMap);
			break;
		case 2:
			readPublisher(myPublishersMap);
			generateMenu();
			break;
		case 3:
			updatePublisher(myPublishersMap);
			break;
		case 4:
			deletePub(myPublishersMap);
			break;
		default:
			System.out.println("Invalid selection. Please choose one of the listed options.");
			generateMenu();
		}
	}

	
	private void createAuthor(Map<Integer, Author> myMap) {
		Author author = new Author(0, "Test");
		System.out.println("Executing create function");
		for (int i = 1; i<=myMap.size()+1; i++) {
			if (!myMap.containsKey(i)) {
				author.setAuthorID(i);
			}
		}
		System.out.println("What is the name of the author you would like to add?");

		author.setAuthorName(scanIn.nextLine());
		myMap.put(author.getAuthorID(), author);
		
		List<String> lines = new ArrayList<>();
		myMap.forEach((key, value) -> lines.add(value.toString()));
		WriteToFileExample.writeAuthor(lines);

		generateMenu();
	}

	private void createBook(Map<Integer, Books> myMap) {
		Books book = new Books(1, "Test", 0, 0);
		System.out.println("Executing create function");
		for (int i = 1; i<=myMap.size()+1; i++) {
			if (!myMap.containsKey(i)) {
				book.setBookID(i);
			}
		}
		System.out.println("What is the name of the book you would like to add?");
		book.setBookName(scanIn.nextLine());
		
		System.out.println("What is the ID of its author?");
		book.setAuthorID(scanIn.nextInt());
		scanIn.nextLine();
		
		System.out.println("What is the ID of its publisher?");
		book.setPublisherID(scanIn.nextInt());
		scanIn.nextLine();
		
		myMap.put(book.getBookID(), book);

		List<String> lines = new ArrayList<>();
		myMap.forEach((key, value) -> lines.add(value.toString()));
		WriteToFileExample.writeBook(lines);
		generateMenu();
	}
	
	private void createPub(Map<Integer, Publisher> myMap) {
		Publisher pub = new Publisher(0000, "Test", "TestLane");
		System.out.println("Executing create function");
		for (int i = 1; i<=myMap.size()+1; i++) {
			if (!myMap.containsKey(i)) {
				pub.setPublisherID(i);
			}
		}
		System.out.println("What is the name of the publisher you would like to add?");
		pub.setPublisherName(scanIn.nextLine());
		
		System.out.println("What is its address?");
		pub.setPublisherAddress(scanIn.nextLine());
		
		myMap.put(pub.getPublisherID(), pub);
		
		List<String> lines = new ArrayList<>();
		myMap.forEach((key, value) -> lines.add(value.toString()));
		WriteToFileExample.writePublisher(lines);
		generateMenu();
	}
	
	private void readAuthors(Map<Integer, Author> myMap) {

		System.out.println("Executing read function");
		myMap.forEach((key, value) -> System.out.println(key + " : " + value.getAuthorName()));
		generateMenu();
	}

	private void readBooks(Map<Integer, Books> myMap) {

		System.out.println("Executing read function");
		myMap.forEach((key, value) -> System.out.println(key + " : " + value.getBookName()));
		generateMenu();
	}

	private void readPublisher(Map<Integer, Publisher> myMap) {

		System.out.println("Executing read function");
		myMap.forEach((key, value) -> System.out.println(key + " : " + value.getPublisherName()));
		generateMenu();
	}

	private void updateAuthors(Map<Integer, Author> myMap) {

		System.out.println("Executing update function");
		myMap.forEach((key, value) -> System.out.println(key + " : " + value.getAuthorName()));
		System.out.println("Which author are you updating?");
		selection = scanIn.nextInt();
		scanIn.nextLine();
		System.out.printf("What is the author's new name?");
		myMap.get(selection).setAuthorName(scanIn.nextLine());
		List<String> lines = new ArrayList<>();
		myMap.forEach((key, value) -> lines.add(value.toString()));
		WriteToFileExample.writeAuthor(lines);
		generateMenu();
	}

	private void updateBooks(Map<Integer, Books> myMap) {

		System.out.println("Executing update function");
		myMap.forEach((key, value) -> System.out.println(key + " : " + value.getBookName()));
		System.out.println("Which book are you updating?");
		selection = scanIn.nextInt();
		scanIn.nextLine();
		System.out.printf("Which field are you updating? %n1. Book Name" + "%n2. Author (ID) %n3. Publisher (ID)");
		int selection2 = scanIn.nextInt();
		int selection3 = 0;
		scanIn.nextLine();
		switch (selection2) {
		case 1:
			System.out.printf("What is the book's new name?");
			String newName = scanIn.nextLine();
			myMap.get(selection).setBookName(newName);
			break;

		case 2:
			System.out.printf("What is the ID of the book's new author?");
			selection3 = scanIn.nextInt();
			myMap.get(selection).setAuthorID(selection3);
			break;

		case 3:
			System.out.printf("What is the ID of the book's new publisher?");
			selection3 = scanIn.nextInt();
			myMap.get(selection).setPublisherID(selection3);
			break;
		}
		List<String> lines = new ArrayList<>();
		myMap.forEach((key, value) -> lines.add(value.toString()));
		WriteToFileExample.writeBook(lines);
		generateMenu();
	}

	private void updatePublisher(Map<Integer, Publisher> myMap) {

		System.out.println("Executing update function");
		myMap.forEach((key, value) -> System.out.println(key + " : " + value.getPublisherName()));
		System.out.println("Which publisher are you updating?");
		selection = scanIn.nextInt();
		scanIn.nextLine();
		System.out.printf("Which field are you updating? %n1. Publisher Name" + "%n2. Publisher Address");
		int selection2 = scanIn.nextInt();
		scanIn.nextLine();
		switch (selection2) {
		case 1:
			System.out.printf("What is the publisher's new name?");
			myMap.get(selection).setPublisherName(scanIn.nextLine());
			break;

		case 2:
			System.out.printf("What is the publisher's new address?");
			myMap.get(selection).setPublisherName(scanIn.nextLine());
			break;
		}
		List<String> lines = new ArrayList<>();
		myMap.forEach((key, value) -> lines.add(value.toString()));
		WriteToFileExample.writePublisher(lines);
		generateMenu();
	}

	private <T> void delete(Map<Integer, T> myMap) {
		System.out.println("Executing delete function");
		generateMenu();
	}
	
	private void deleteAuthor(Map<Integer, Author> myMap) {
		System.out.println("Executing delete function");
		myMap.forEach((key, value) -> System.out.println(key + " : " + value.getAuthorName()));
		System.out.println("Which author would you like to delete?");
		
		selection = scanIn.nextInt();
		scanIn.nextLine();
		
		myMap.remove(selection);
		generateMenu();
	}
	
	private void deleteBook(Map<Integer, Books> myMap) {
		System.out.println("Executing delete function");
		myMap.forEach((key, value) -> System.out.println(key + " : " + value.getBookName()));
		System.out.println("Which book would you like to delete?");
		
		selection = scanIn.nextInt();
		scanIn.nextLine();
		
		myMap.remove(selection);
		generateMenu();
	}
	
	private void deletePub(Map<Integer, Publisher> myMap) {
		System.out.println("Executing delete function");
		myMap.forEach((key, value) -> System.out.println(key + " : " + value.getPublisherName()));
		System.out.println("Which publisher would you like to delete?");
		
		selection = scanIn.nextInt();
		scanIn.nextLine();
		
		myMap.remove(selection);
		generateMenu();
	}

}
