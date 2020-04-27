package com.ss.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.dao.AuthorDAO;
import com.ss.lms.dao.BookDAO;
import com.ss.lms.dao.BorrowerDAO;
import com.ss.lms.dao.LibraryDAO;
import com.ss.lms.entity.Author;
import com.ss.lms.entity.Book;
import com.ss.lms.entity.Borrower;
import com.ss.lms.entity.Library;

public class AdminService {

	public ConnectionUtil connUtil = new ConnectionUtil();

	public void saveAuthor(Author author) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			if (author.getAuthorId() != null && author.getAuthorName() != null) {
				adao.updateAuthor(author);
			} else if (author.getAuthorId() != null) {
				adao.deleteAuthor(author);
			} else {
				adao.addAuthor(author);
			}
			conn.commit(); // transaction
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public List<Author> readAuthors(Integer pk, String authorName) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			BookDAO bdao = new BookDAO(conn);
			if (pk != null) {
				// get author by primary key
			} else if (authorName != null) {
				// searchAuthors
			} else {
				List<Author> authors = adao.readAllAuthors();
				for (Author a : authors) {
					a.setBooks(bdao.readAllBooksByAuthor(a.getAuthorId()));
				}
				return authors;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<Library> readLibrary(Integer pk, String branchName) {
		Connection conn = null;
		List<Library> lib = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			BookDAO bdao = new BookDAO(conn);
			LibraryDAO ldao = new LibraryDAO(conn);
			if (pk != null) {
				lib = ldao.readLibrarys(pk);
			} else if (branchName != null) {
				// searchAuthors
			} else {
				lib = ldao.readAllLibrarys();
			}
			return lib;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<Book> readBook(Integer pk, String title) {
		Connection conn = null;
		List<Book> books = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			BookDAO bdao = new BookDAO(conn);
			if (pk != null) {
				books = bdao.readBooks(pk);
			} else if (title != null) {
				// searchAuthors
			} else {
				books = bdao.readAllBooks();
			}
			return books;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public void saveBook(Book book) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookDAO ldao = new BookDAO(conn);
			if (book.getBookId() != null && book.getTitle() != null) {
				ldao.updateBook(book);
			} else if (book.getBookId() != null) {
				ldao.deleteBook(book);
			} else {
				ldao.addBook(book);
			}
			conn.commit(); // transaction
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String readCopies(Integer branch, Integer book) {
		String answer ="";
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			if (branch != null && book != null) {
				bdao.readCopies(branch, book);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return answer;

	}
	

	public void updateCopies(Integer copies, Integer branch, Integer book) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			if (copies != null && branch != null && book != null) {
				bdao.updateCopies(copies, branch, book);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void saveLibrary(Library library) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryDAO ldao = new LibraryDAO(conn);
			if (library.getBranchId() != null && library.getBranchName() != null) {
				ldao.updateLibrary(library);
			} else if (library.getBranchId() != null) {
				ldao.deleteLibrary(library);
			} else {
				ldao.addLibrary(library);
			}
			conn.commit(); // transaction
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public List<Borrower> readBorrower(Integer pk, String branchName) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BorrowerDAO brdao = new BorrowerDAO(conn);
			if (pk != null) {
				// get author by primary key
			} else if (branchName != null) {
				// searchAuthors
			} else {
				List<Borrower> bors = brdao.readAllBorrowers();

				return bors;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
