package com.nagarro.microservices.AccountManagement.model;

import java.util.ArrayList;
import java.util.List;


public class Customer {
	private int custId;
	private String name;
	private String address;
	private String phoneNo;
	List<Accounts> account=new ArrayList<>();
	
	public Customer()
	{}
	public Customer(int custId, String name, String address, String phoneNo) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	
	public Customer(int custId, String name, String address, String phoneNo, List<Accounts> account) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.account = account;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public List<Accounts> getAccount() {
		return account;
	}
	public void setAccount(List<Accounts> account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo
				+ ", account=" + account + "]";
	}
	
	
	
	
	
	
	
}