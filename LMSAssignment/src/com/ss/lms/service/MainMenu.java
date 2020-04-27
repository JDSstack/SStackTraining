package com.ss.lms.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ss.lms.entity.Author;
import com.ss.lms.entity.Book;
import com.ss.lms.entity.Library;

public class MainMenu {
	private int selection;
	private Scanner scanIn = new Scanner(System.in);
	private AdminService admin = new AdminService();

	public static void main(String[] args) throws SQLException {
		MainMenu main = new MainMenu();
	}

	public MainMenu() throws SQLException {
		generateUserMenu();
	}

	private void generateUserMenu() throws SQLException {
		System.out.printf("Welcome to the GCIT Library Management System. Which category of a user are you:%n%n"
				+ "1. Librarian %n2. Administrator%n3. Borrower%n4. Close Program%n%n");
		try {
			selection = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only for navigation.");
			scanIn.nextLine();
			generateUserMenu();
		}

		switch (selection) {
		case 1:
			libraryMenu();
			break;
		case 2:
			adminMenu();
			break;
		case 3:
			borrowerMenu();
			break;
		case 4:
			System.out.println("Closing Program.");
			System.exit(0);
		default:
			System.out.println("Invalid selection. Please choose one of the listed options.");
			generateUserMenu();
		}
	}

	private void libraryMenu() throws SQLException {
		List<Library> tempList = new ArrayList<>();
		tempList = admin.readLibrary(null, null);
		tempList.forEach(n -> System.out.println(n.getBranchId() + "). " + n.getBranchName()));
		System.out.printf(
				"Enter the number of the library you would like to access, %nor enter 0 to return to the previous menu.%n");
		try {
			selection = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only for navigation.");
			scanIn.nextLine();
			libraryMenu();
		}
		if (selection == 0) {
			generateUserMenu();
		} else {
			librarySubMenu(selection);
		}
	}

	private void librarySubMenu(Integer libNum) throws SQLException {
		System.out.printf("What would you like to do:%n%n"
				+ "1. Update details of the library %n2. Add copies of book to branch%n3. Return to previous menu%n%n");
		try {
			selection = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only for navigation.");
			scanIn.nextLine();
			librarySubMenu(libNum);
		}
		switch (selection) {
		case 1:
			updateBranchDetails(libNum);
			break;
		case 2:
			updateBookCopies(libNum);
			break;
		case 3:
			libraryMenu();
			break;
		default:
			System.out.println("Invalid selection. Please choose one of the listed options.");
			librarySubMenu(libNum);
		}
	}
	
	private void updateBranchDetails(Integer libNum) throws SQLException {
		//Get name and ID for library, then overwrite with new input value, then go back to librarySubMenu()
		StringBuilder name = new StringBuilder();
		StringBuilder address = new StringBuilder();
		
		List<Library> tempList = new ArrayList<>();
		tempList = admin.readLibrary(libNum, null);	
		
		tempList.forEach(n -> System.out.println(n.getBranchId() + "). " + n.getBranchName()));
		
		System.out.println("Please input new branch name, or type quit to return: ");
		
		name.append(scanIn.nextLine());
		if(name.toString().equals("quit")) {
			librarySubMenu(libNum);
		}
		
		System.out.println("Please input new branch address, or type quit to return: ");

		address.append(scanIn.nextLine());
		if(address.toString().equals("quit")) {
			librarySubMenu(libNum);
		}
		Library tempLib = new Library();
		tempLib.setBranchName(name.toString());
		tempLib.setBranchAddress(name.toString());
		tempLib.setBranchId(libNum);
		
		admin.saveLibrary(tempLib);
		
		tempList = admin.readLibrary(libNum, null);	
		tempList.forEach(n -> System.out.println(n.getBranchId() + "). " + n.getBranchName()));
		
		librarySubMenu(libNum);
	}
	

	private void updateBookCopies(Integer libNum) throws SQLException {
		//Get number of book copies for library, then overwrite with new input value, then go back to librarySubMenu()
		int bookNum = 0;
		int newCopies = 0;
		List<Book> bookList = new ArrayList<>();
		bookList = admin.readBook(null, null);	
		bookList.forEach(n -> System.out.println(n.getBookId() + "). " + n.getTitle()));
		
		System.out.println("Please select which book you would like to add to this branch: ");
		try {
			bookNum = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only.");
			scanIn.nextLine();
			updateBookCopies(libNum);
		}
		
		System.out.println("Please select the current number of copies in this branch ");
		try {
			newCopies = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only.");
			scanIn.nextLine();
			updateBookCopies(libNum);
		}
		admin.updateCopies(newCopies, selection, bookNum);

		
	}
	
	private void borrowerMenu() throws SQLException {
		System.out.println("What is your card number: ");
		int cardNum = 0;
		try {
			cardNum = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only.");
			scanIn.nextLine();
			borrowerMenu();
		}
		//Do some user validation with selection
		System.out.printf("What would you like to do :%n%n"
				+ "1. Check out a book %n2. Return a book%n3. Return to previous menu%n%n");	
		try {
			selection = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only.");
			scanIn.nextLine();
			borrowerMenu();
		}
		switch (selection) {
		case 1:
			checkOutBook(cardNum);
			break;
		case 2:
			returnBook(cardNum);
			break;
		case 3:
			generateUserMenu();
			break;
		default:
			System.out.println("Invalid selection. Please choose one of the listed options.");
			borrowerMenu();
		}
		
	}
	private void checkOutBook(Integer cardNum) throws SQLException {
		//Select library branch to check out from
		//Pick the Book you want to check out 
		//(make sure you only show books that have atleast one copy in BOOK_COPIES in the branch picked)
		//Then add entry into book_loans, date out should be today’s date, 
		//due date should be one week from today’s date.
		
		List<Library> tempList = new ArrayList<>();
		tempList = admin.readLibrary(null, null);
		tempList.forEach(n -> System.out.println(n.getBranchId() + "). " + n.getBranchName()));
		System.out.printf(
				"Enter the number of the library you would like to check out from.%n");
		try {
			selection = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only for navigation.");
			scanIn.nextLine();
			checkOutBook(cardNum);
		}
		//
		int bookNum = 0;
		int newCopies = 0;
		List<Book> bookList = new ArrayList<>();
		bookList = admin.readBook(null, null);	
		bookList.forEach(n -> System.out.println(n.getBookId() + "). " + n.getTitle()));
		
		System.out.println("Please select which book you would like to checkout this branch: ");
		try {
			bookNum = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only.");
			scanIn.nextLine();
			checkOutBook(cardNum);
			}
		
		
		admin.updateCopies(newCopies, selection, bookNum);


		//
	}
	private void returnBook(Integer cardNum) throws SQLException {
		//Similar to checkOutBook
		//Give some thought to business rules? What happens to the book_loan entry when book is returned
		
		List<Library> tempList = new ArrayList<>();
		tempList = admin.readLibrary(null, null);
		tempList.forEach(n -> System.out.println(n.getBranchId() + "). " + n.getBranchName()));
		System.out.printf(
				"Enter the number of the library you would like to check out from.%n");
		try {
			selection = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only for navigation.");
			scanIn.nextLine();
			returnBook(cardNum);
		}
		//
		int bookNum = 0;
		int newCopies = 0;
		List<Book> bookList = new ArrayList<>();
		bookList = admin.readBook(null, null);	
		bookList.forEach(n -> System.out.println(n.getBookId() + "). " + n.getTitle()));
		
		System.out.println("Please select which book you would like to checkout this branch: ");
		try {
			bookNum = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only.");
			scanIn.nextLine();
			returnBook(cardNum);
			}
		
		
		admin.updateCopies(newCopies, selection, bookNum);
	}
	
	private void adminMenu() {
		System.out.printf("What would you like to do :%n" +
				"1.	Add/Update/Delete/Read Book and Author%n" + 
				"2.	Add/Update/Delete/Read Genres%n" + 
				"3.	Add/Update/Delete/Read Publishers%n" + 
				"4.	Add/Update/Delete/Read Library Branches%n" + 
				"5.	Add/Update/Delete/Read Borrowers%n" + 
				"6.	Over-ride Due Date for a Book Loan%n%n");	
		try {
			selection = scanIn.nextInt();
			scanIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid selection. Please input integers only.");
			scanIn.nextLine();
			adminMenu();
		}
		switch (selection) {
		case 1:
			//adminAuthorBooks();
			break;
		case 2:
			//adminGenres();
			break;
		case 3:
			//adminPublishers();
			break;
		case 4:
			//adminLibraryBranches();
		case 5:
			//adminBorrowers();
		case 6:
			//adminDueDateOverride();
		default:
			System.out.println("Invalid selection. Please choose one of the listed options.");
			adminMenu();
		}
	}

}