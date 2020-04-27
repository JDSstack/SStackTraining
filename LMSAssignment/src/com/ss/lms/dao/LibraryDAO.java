package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.entity.Library;

public class LibraryDAO extends BaseDAO<Library>{

	public LibraryDAO(Connection conn) {
		super(conn);
	}

	public void addLibrary(Library library) throws ClassNotFoundException, SQLException{
		saveWithPK("INSERT INTO tbl_library_branch (branchName) VALUES (?)", new Object[] {library.getBranchName()});
	}

	public void updateLibrary(Library library)  throws ClassNotFoundException, SQLException{
		save("UPDATE tbl_library_branch SET branchName = ? WHERE branchId = ?", new Object[] {library.getBranchName(), library.getBranchId()});
	}

	public void deleteLibrary(Library library)  throws ClassNotFoundException, SQLException{
		save("DELETE FROM tbl_library_branch WHERE branchId = ?", new Object[]{library.getBranchId()});
	}
	
	public List<Library> readLibrarys(Integer branchId) throws ClassNotFoundException, SQLException{
		return read("SELECT * FROM tbl_library_branch WHERE branchId = ?", new Object[]{branchId});
	}	
	public List<Library> readAllLibrarys() throws ClassNotFoundException, SQLException{
		return read("SELECT * FROM tbl_library_branch", null);
	}
	
	
	@Override
	public List<Library> extractData(ResultSet rs) throws SQLException {
		List<Library> librarys = new ArrayList<>();
		while(rs.next()){
			Library library = new Library();
			library.setBranchId(rs.getInt("branchId"));
			library.setBranchName(rs.getString("branchName"));
			librarys.add(library);
		}
		return librarys;
	}

}
