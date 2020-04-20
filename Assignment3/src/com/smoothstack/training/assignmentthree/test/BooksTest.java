package com.smoothstack.training.assignmentthree.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.smoothstack.training.assignmentthree.Books;

public class BooksTest {

	@Test
	public void BooksConstructer() {
		Books books = new Books(1,"SpiderMan", 2, 3);
		assertEquals(books.getClass(), Books.class);
	}
	
	@Test
	public void BooksGetters() {
		Books books = new Books(1,"SpiderMan", 2, 3);
		assertEquals(1, books.getBookID(), 0.0001);
		assertEquals("SpiderMan", books.getBookName());
		assertEquals(2, books.getAuthorID(), 0.0001);
		assertEquals(3, books.getPublisherID(),0.0001);

	}
	
	@Test
	public void BooksSetters() {
		Books books = new Books(0,"", 0, 0);
		books.setBookID(9);
		books.setBookName("Superman");
		books.setAuthorID(5);
		books.setPublisherID(2);
		
		assertEquals(9, books.getBookID(), 0.0001);
		assertEquals("Superman", books.getBookName());
		assertEquals(5, books.getAuthorID(), 0.0001);
		assertEquals(2, books.getPublisherID(),0.0001);

	}
	
}
