package com.smoothstack.training.assignmentthree.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.smoothstack.training.assignmentthree.Author;



public class AuthorTest {

	@Test
	public void authorConstructer() {
		Author author = new Author(0,"John");
		assertEquals(author.getClass(), Author.class);
	}
	
	@Test
	public void authorGetters() {
		Author newAuthor = new Author(7,"John");
		assertEquals(7, newAuthor.getAuthorID(), 0.0001);
		assertEquals("John", newAuthor.getAuthorName());
	}
	
	@Test
	public void authorSetters() {
		Author author = new Author(0, "");
		author.setAuthorID(8);
		author.setAuthorName("Phil");
		assertEquals(8, author.getAuthorID(), 0.0001);
		assertEquals("Phil", author.getAuthorName());
	}
}

