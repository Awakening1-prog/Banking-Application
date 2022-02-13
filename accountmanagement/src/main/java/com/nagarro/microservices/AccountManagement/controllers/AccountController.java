package com.nagarro.microservices.AccountManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.AccountManagement.model.Accounts;
import com.nagarro.microservices.AccountManagement.model.Customer;
import com.nagarro.microservices.AccountManagement.service.AccountService;

@RestController
public class AccountController {
	int balance=0;
	@Autowired
	private AccountService accountService;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	
	
	@GetMapping("/account/{id}")
	public List<Accounts> getAccount(@PathVariable("id") int id)
	{
		return this.accountService.getllAccountDetails(id);	
	}
	
	@PostMapping("/account/add/{id}")
	public  ResponseEntity<String> addBalance(@PathVariable("id") int id , @RequestBody Accounts a)
	{
		return this.accountService.addBalance(id,a);
		
	}
	
	@PutMapping("/account/withdraw/{id}")
	public ResponseEntity<String> withdrawBalance(@PathVariable("id") int id ,@RequestBody Accounts aa)
	{
		return this.accountService.getWithdrawBalance(id, aa);
	}
	
	@DeleteMapping("/account/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id") int id)
	{
		return this.accountService.getDelete(id);
		
	}
	

}

//{
//    "accId":1,
//    "accountNo":123458,
//    "balance":10000,
//    "custId":10
//    }