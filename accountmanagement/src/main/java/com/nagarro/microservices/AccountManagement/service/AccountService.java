package com.nagarro.microservices.AccountManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.AccountManagement.model.Accounts;
import com.nagarro.microservices.AccountManagement.model.Customer;

@Service
@RefreshScope
public class AccountService {
	
	ArrayList<Accounts> account = new ArrayList<>();
	ArrayList<Accounts> acc = new ArrayList<>();
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	
	@Value("${customer.provider.url}")
	  private String url;
	
	public AccountService()
	{		
		Accounts a1=new Accounts(1,12345,0,101);
		Accounts a2=new Accounts(2,12346,0,102);
		Accounts a3=new Accounts(3,12347,0,103);
		account.add(a1);
		account.add(a2);
		account.add(a3);

	}
	
	public List<Accounts> getAccountDetails()
	{
		return this.account;
	}
	
	public Accounts getAccountDetails(int id)
	{
		for(Accounts a : account)
		{
			if(a.getCustId()==id)
			{
				
				ArrayList<Accounts> acc= new ArrayList<>();
				acc.add(a);
				return a;
			}
		}
		return null;
	}
	
	public ArrayList<Accounts> getllAccountDetails(int id)
	{
		for(Accounts a : account)
		{
			if(a.getCustId()==id)
			{
				
				ArrayList<Accounts> acc= new ArrayList<>();
				acc.add(a);
				return acc;
			}
		}
		return null;
	}
	
	public ResponseEntity<String> addBalance(int id,Accounts a)
	{
		account.add(a);
		try
		{
			Accounts acc=this.getAccountDetails(id);
			int dummybalance=acc.getBalance()+a.getBalance();
			acc.setBalance(dummybalance);
			return ResponseEntity.status(HttpStatus.CREATED).body("Amount Credited Successfully");
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			return ResponseEntity.of(Optional.of("User is Invalid"));
			
		}
			
	}
	
	public ResponseEntity<String> getDelete(int id )
	{
		try
		{
			for(Accounts a: account)
			{
				if(a.getCustId()==id)
				{
					account.remove(a);
					break;
				}
			}
			return ResponseEntity.status(HttpStatus.CREATED).body("Amount Account Deleted Successfully");
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			return ResponseEntity.of(Optional.of("User is Invalid"));
			
		}
	}
	
	public ResponseEntity<String> getWithdrawBalance(int id, Accounts aa)
	{
		try
		{
			Accounts a=this.getAccountDetails(id);
			if(a.getCustId()==id && a.getBalance()>=aa.getBalance())
			{
				int dummyBalance=a.getBalance()-aa.getBalance();
				a.setBalance(dummyBalance);
				return ResponseEntity.status(HttpStatus.CREATED).body("Money withdrawn Successfully");
				
			}
			if(a.getCustId()==id && a.getBalance()<aa.getBalance())
			{
				return ResponseEntity.status(HttpStatus.CREATED).body("You have Insufficient Balance");
				
			}
			
		return ResponseEntity.status(HttpStatus.CREATED).body("User is Invalid");
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			return ResponseEntity.of(Optional.of("User is Invalid"));
			
		}
	}

	
	
}
