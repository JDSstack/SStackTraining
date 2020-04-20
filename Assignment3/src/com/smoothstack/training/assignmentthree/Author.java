//Jeremy Didier
//4-19-20
//Smoothstack Assignment 3

package com.smoothstack.training.assignmentthree;

import java.io.Serializable;

public class Author implements Serializable, Comparable<Author> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5106029509164648881L;
	private Integer authorID;
	private String authorName;

	public Author(Integer authorID, String authorName) {
		this.authorID = authorID;
		this.authorName = authorName;
	}

	public Integer getAuthorID() {
		return authorID;
	}

	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorID == null) ? 0 : authorID.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
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
		Author other = (Author) obj;
		if (authorID == null) {
			if (other.authorID != null)
				return false;
		} else if (!authorID.equals(other.authorID))
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		return true;
	}

	@Override
	public int compareTo(Author o) {
		// TODO Auto-generated method stub
		return this.getAuthorID() - o.getAuthorID();
	}
	
	@Override
    public String toString() { 
        return String.format(this.getAuthorID()+","+this.getAuthorName());
    } 

}
