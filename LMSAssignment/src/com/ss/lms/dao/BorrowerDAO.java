package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.entity.Borrower;

public class BorrowerDAO extends BaseDAO<Borrower>{

	public BorrowerDAO(Connection conn) {
		super(conn);
	}

	public void addBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		saveWithPK("INSERT INTO tbl_borrower (name) VALUES (?)", new Object[] {borrower.getName()});
	}

	public void updateBorrower(Borrower borrower)  throws ClassNotFoundException, SQLException{
		save("UPDATE tbl_borrower SET name = ? WHERE cardNo = ?", new Object[] {borrower.getName(), borrower.getCardNo()});
	}

	public void deleteBorrower(Borrower borrower)  throws ClassNotFoundException, SQLException{
		save("DELETE FROM tbl_borrower WHERE cardNo = ?", new Object[]{borrower.getCardNo()});
	}
	
	public List<Borrower> readAllBorrowers() throws ClassNotFoundException, SQLException{
		return read("SELECT * FROM tbl_borrower", null);
	}
	
	
	@Override
	public List<Borrower> extractData(ResultSet rs) throws SQLException {
		List<Borrower> borrowers = new ArrayList<>();
		while(rs.next()){
			Borrower borrower = new Borrower();
			borrower.setCardNo(rs.getInt("cardNo"));
			borrower.setName(rs.getString("name"));
			borrowers.add(borrower);
		}
		return borrowers;
	}

}
