package com.smoothstack.training.assignmentthree.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.smoothstack.training.assignmentthree.Author;
import com.smoothstack.training.assignmentthree.Books;
import com.smoothstack.training.assignmentthree.MainMenu;
import com.smoothstack.training.assignmentthree.Publisher;

public class MainMenuTest {
	
	@Test
	public void menuTest() {
		Map<Integer, Author> testAuthorMap = new TreeMap<>();
		Map<Integer, Books> testBooksMap = new TreeMap<>();
		Map<Integer, Publisher> testPublishersMap = new TreeMap<>();
		MainMenu menu = new MainMenu(testAuthorMap, testBooksMap, testPublishersMap);
		//Every method inside MainMenu aside from its constructor, is private.
		//I'm not sure how to conduct JUnitTests for private void methods without changing their security
	
	}

}
