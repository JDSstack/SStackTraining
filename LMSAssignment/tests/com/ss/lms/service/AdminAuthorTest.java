package com.ss.lms.service;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

public class AdminAuthorTest {
	
	@Test
	public void readAuthorsTest() throws SQLException{
		AdminService adminService = new AdminService();
		assertNotNull(adminService.readAuthors(null, null));
	}

}
