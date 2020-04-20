package com.smoothstack.training.assignmentthree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

public class FileReaderService {


	public static void prepTables(Map<Integer, Author> myAuthorMap, Map<Integer, Books> myBooksMap,
			Map<Integer, Publisher> myPublishersMap) {
		//Loads input files into maps
		prepAuthor(myAuthorMap);
		prepBooks(myBooksMap);
		prepPubs(myPublishersMap);
	}

	private static void prepAuthor(Map<Integer, Author> myMap) {
		try (BufferedReader bufStream = new BufferedReader(new FileReader("resources/inputfiles/author.txt"))) {

			String line = bufStream.readLine();
			while (line != null) {
				Author author = new Author(1, "Test");
				String[] fields = line.split(",");
				author.setAuthorID(Integer.parseInt(fields[0]));
				author.setAuthorName(fields[1]);
				// System.out.println("Author ID: " + author.getAuthorID() + " & Author Name:" +
				// author.getAuthorName());
				myMap.put(author.getAuthorID(), author);
				line = bufStream.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read from File");

		}
	}

	private static void prepBooks(Map<Integer, Books> myMap) {
		try (BufferedReader bufStream = new BufferedReader(new FileReader("resources/inputfiles/books.txt"))) {

			String line = bufStream.readLine();
			while (line != null) {
				Books book = new Books(1, "Test", 0, 0);
				String[] fields = line.split(",");
				book.setBookID(Integer.parseInt(fields[0]));
				book.setBookName(fields[1]);
				book.setAuthorID(Integer.parseInt(fields[2]));
				book.setPublisherID(Integer.parseInt(fields[3]));

				myMap.put(book.getBookID(), book);
				line = bufStream.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read from File");

		}
	}

	private static void prepPubs(Map<Integer, Publisher> myMap) {
		try (BufferedReader bufStream = new BufferedReader(new FileReader("resources/inputfiles/publisher.txt"))) {

			String line = bufStream.readLine();
			while (line != null) {
				Publisher pub = new Publisher(0000, "Test", "TestLane");
				String[] fields = line.split(",");
				pub.setPublisherID(Integer.parseInt(fields[0]));
				pub.setPublisherName(fields[1]);
				pub.setPublisherAddress(fields[2]);
				myMap.put(pub.getPublisherID(), pub);
				line = bufStream.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read from File");

		}
	}

}