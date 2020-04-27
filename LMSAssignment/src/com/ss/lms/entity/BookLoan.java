package com.ss.lms.entity;

import java.time.LocalDateTime;

public class BookLoan {
	private Integer bookId;
	private Integer branchId;
	private Integer cardNo;
	
	private LocalDateTime dateOut;
	private LocalDateTime dueDate;
	private LocalDateTime dateIn;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public Integer getCardNo() {
		return cardNo;
	}
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	public LocalDateTime getDateOut() {
		return dateOut;
	}
	public void setDateOut(LocalDateTime dateOut) {
		this.dateOut = dateOut;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDateTime getDateIn() {
		return dateIn;
	}
	public void setDateIn(LocalDateTime dateIn) {
		this.dateIn = dateIn;
	}
	
	

}