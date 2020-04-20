package com.smoothstack.training.assignmentthree.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.smoothstack.training.assignmentthree.Publisher;


public class PublisherTest {
	@Test
	public void PublisherConstructer() {
		Publisher pubs = new Publisher(1,"Marvel", "Disney Lane");
		assertEquals(pubs.getClass(), Publisher.class);
	}
	
	@Test
	public void PublisherGetters() {
		Publisher pubs = new Publisher(1,"Marvel", "Disney Lane");
		assertEquals(1, pubs.getPublisherID(), 0.0001);
		assertEquals("Marvel", pubs.getPublisherName());
		assertEquals("Disney Lane", pubs.getPublisherAddress());

	}
	
	@Test
	public void PublisherSetters() {
		Publisher pubs = new Publisher(0,"","");
		pubs.setPublisherID(11);
		pubs.setPublisherName("DC");
		pubs.setPublisherAddress("Batman Road");
		
		assertEquals(11, pubs.getPublisherID(), 0.0001);
		assertEquals("DC", pubs.getPublisherName());
		assertEquals("Batman Road", pubs.getPublisherAddress());
	}
	
}
