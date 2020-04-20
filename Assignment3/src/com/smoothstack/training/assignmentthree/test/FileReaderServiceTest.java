package com.smoothstack.training.assignmentthree.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.smoothstack.training.assignmentthree.Author;
import com.smoothstack.training.assignmentthree.Books;
import com.smoothstack.training.assignmentthree.Publisher;
import com.smoothstack.training.assignmentthree.FileReaderService;


public class FileReaderServiceTest {

	@Test
	public void prepTableTest() {
		Map<Integer, Author> testAuthorMap = new TreeMap<>();
		Map<Integer, Books> testBooksMap = new TreeMap<>();
		Map<Integer, Publisher> testPublishersMap = new TreeMap<>();
		FileReaderService.prepTables(testAuthorMap, testBooksMap, testPublishersMap);
		
		assertEquals(true, testAuthorMap.containsKey(1));
		assertEquals(true, testBooksMap.containsKey(1));
		assertEquals(true, testPublishersMap.containsKey(1));
	}
	
}
