package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.entity.Book;
import com.ss.lms.entity.BookLoan;

public class BookLoanDAO extends BaseDAO<BookLoan>{

	public BookLoanDAO(Connection conn) {
		super(conn);
	}

	
	@Override
	public List<BookLoan> extractData(ResultSet rs) throws SQLException {
		List<BookLoan> loans = new ArrayList<>();
		while(rs.next()){
		}
		return loans;
	}

}
