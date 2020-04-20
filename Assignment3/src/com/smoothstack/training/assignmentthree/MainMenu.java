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

		switch (selection) {
		case 1:
			create(myAuthorMap);
			break;
		case 2:
			readAuthors(myAuthorMap);
			break;
		case 3:
			updateAuthors(myAuthorMap);
			break;
		case 4:
			delete(myAuthorMap);
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

		switch (selection) {
		case 1:
			create(myBooksMap);
			break;
		case 2:
			readBooks(myBooksMap);
			break;
		case 3:
			updateBooks(myBooksMap);
			break;
		case 4:
			delete(myBooksMap);
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

		switch (selection) {
		case 1:
			create(myPublishersMap);
			break;
		case 2:
			readPublisher(myPublishersMap);
			generateMenu();
			break;
		case 3:
			updatePublisher(myPublishersMap);
			break;
		case 4:
			delete(myPublishersMap);
			break;
		default:
			System.out.println("Invalid selection. Please choose one of the listed options.");
			generateMenu();
		}
	}

	private <T> void create(Map<Integer, T> myMap) {
		System.out.println("Executing create function");
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
		String newName = scanIn.nextLine();
		myMap.get(selection).setAuthorName(newName);
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
		String newName = "";
		scanIn.nextLine();
		switch (selection2) {
		case 1:
			System.out.printf("What is the publisher's new name?");
			newName = scanIn.nextLine();
			myMap.get(selection).setPublisherName(newName);
			break;

		case 2:
			System.out.printf("What is the publisher's new address?");
			newName = scanIn.nextLine();
			myMap.get(selection).setPublisherName(newName);
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

}
