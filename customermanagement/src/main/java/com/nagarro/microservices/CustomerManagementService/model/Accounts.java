package com.nagarro.microservices.CustomerManagementService.model;



public class Accounts {
	private int accId;
	private int accountNo;
	private int balance;
	private int custId;
	public Accounts() {}
	public Accounts(int accId, int accountNo, int balance, int custId) {
		super();
		this.accId = accId;
		this.accountNo = accountNo;
		this.balance = balance;
		this.custId = custId;
	}
	
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	@Override
	public String toString() {
		return "Accounts [accId=" + accId + ", accountNo=" + accountNo + ", balance=" + balance + ", custId=" + custId
				+ "]";
	}
	

}
