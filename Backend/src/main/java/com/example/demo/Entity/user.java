package com.example.demo.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class user {

	@Id
	private long contactNo;
	
	private String accountNo;
	
	private String userName;
	
	private String debitCardNo;
	
	private String accountType;
	
	private LocalDate expiryDate;

	public user(long contactNo, String accountNo, String userName, String debitCardNo, String accountType,
			LocalDate expiryDate) {
		super();
		this.contactNo = contactNo;
		this.accountNo = accountNo;
		this.userName = userName;
		this.debitCardNo = debitCardNo;
		this.accountType = accountType;
		this.expiryDate = expiryDate;
	}
	
	public user() {
		
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDebitCardNo() {
		return debitCardNo;
	}

	public void setDebitCardNo(String debitCardNo) {
		this.debitCardNo = debitCardNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
}
