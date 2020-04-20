package com.smoothstack.training.assignmentthree.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.smoothstack.training.assignmentthree.Author;
import com.smoothstack.training.assignmentthree.Books;
import com.smoothstack.training.assignmentthree.Publisher;
import com.smoothstack.training.assignmentthree.WriteToFileService;

public class WriteToFileServiceTest {
	
	@Test
	public void writeTest() {
		List<String> lines = new ArrayList<>();
		Map<Integer, Author> testAuthorMap = new TreeMap<>();
		try (BufferedReader bufStream = new BufferedReader(new FileReader("resources/inputfiles/author.txt"))) {

			String line = bufStream.readLine();
			while (line != null) {
				Author author = new Author(1, "Test");
				String[] fields = line.split(",");
				//Read in from file as string, delineate by commas, 
				//split each variable from string into array of variables to construct objects with
				author.setAuthorID(Integer.parseInt(fields[0]));
				author.setAuthorName(fields[1]);
				//append objects to map
				testAuthorMap.put(author.getAuthorID(), author);
				line = bufStream.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read from File");

		}
		
		assertEquals(true, testAuthorMap.containsKey(1));
		testAuthorMap.forEach((key, value) -> lines.add(value.toString()));
		WriteToFileService.writeAuthor(lines);
		
	}

}
