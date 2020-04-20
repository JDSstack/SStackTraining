//Jeremy Didier
//4-19-20
//Smoothstack Assignment 3

package com.smoothstack.training.assignmentthree;

import java.io.Serializable;

public class Books implements Serializable, Comparable<Books>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1318966332951622778L;
	private Integer bookID;
	private String bookName;
	private Integer authorID;
	private Integer publisherID;

	public Books(Integer bookID, String bookName, Integer authorID, Integer publisherID) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.authorID = authorID;
		this.publisherID = publisherID;
	}

	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getAuthorID() {
		return authorID;
	}

	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}

	public Integer getPublisherID() {
		return publisherID;
	}

	public void setPublisherID(Integer publisherID) {
		this.publisherID = publisherID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorID == null) ? 0 : authorID.hashCode());
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((publisherID == null) ? 0 : publisherID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (authorID == null) {
			if (other.authorID != null)
				return false;
		} else if (!authorID.equals(other.authorID))
			return false;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (publisherID == null) {
			if (other.publisherID != null)
				return false;
		} else if (!publisherID.equals(other.publisherID))
			return false;
		return true;
	}

	@Override
	public int compareTo(Books o) {

		return this.getBookID() - o.getBookID();
	}
	
	@Override
    public String toString() { 
        return String.format(this.getBookID()+","+this.getBookName()+","+this.getAuthorID()+","+this.getPublisherID()); 
    } 

}
