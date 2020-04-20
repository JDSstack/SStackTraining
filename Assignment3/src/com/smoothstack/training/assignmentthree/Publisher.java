//Jeremy Didier
//4-19-20
//Smoothstack Assignment 3

package com.smoothstack.training.assignmentthree;

import java.io.Serializable;

public class Publisher implements Serializable, Comparable<Publisher> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3297159119774491052L;
	private Integer publisherID;
	private String publisherName;
	private String publisherAddress;

	public Publisher(Integer publisherID, String publisherName, String publisherAddress) {
		this.publisherID = publisherID;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
	}

	public Integer getPublisherID() {
		return publisherID;
	}

	public void setPublisherID(Integer publisherID) {
		this.publisherID = publisherID;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((publisherAddress == null) ? 0 : publisherAddress.hashCode());
		result = prime * result + ((publisherID == null) ? 0 : publisherID.hashCode());
		result = prime * result + ((publisherName == null) ? 0 : publisherName.hashCode());
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
		Publisher other = (Publisher) obj;
		if (publisherAddress == null) {
			if (other.publisherAddress != null)
				return false;
		} else if (!publisherAddress.equals(other.publisherAddress))
			return false;
		if (publisherID == null) {
			if (other.publisherID != null)
				return false;
		} else if (!publisherID.equals(other.publisherID))
			return false;
		if (publisherName == null) {
			if (other.publisherName != null)
				return false;
		} else if (!publisherName.equals(other.publisherName))
			return false;
		return true;
	}

	@Override
	public int compareTo(Publisher o) {
		// TODO Auto-generated method stub
		return this.getPublisherID() - o.getPublisherID();
	}
	
	@Override
    public String toString() { 
        return String.format(this.getPublisherID()+","+this.getPublisherName()+","+this.getPublisherAddress());
    } 

}
