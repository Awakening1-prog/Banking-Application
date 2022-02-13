package com.nagarro.microservices.CustomerManagementService.service;

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

import com.nagarro.microservices.CustomerManagementService.model.Accounts;
import com.nagarro.microservices.CustomerManagementService.model.Customer;

@Service
@RefreshScope
public class CustomerService {
	
	  ArrayList<Customer> cust = new ArrayList<>();
	  
	  @Value("${account.provider.url}")
	  private String url;
	  
	 public CustomerService()
	 {
	 
	 Customer c1=new Customer(101,"Utkarsh","LKO","99999");
	 Customer c2=new Customer(102,"Aditya","LKO","88888");
	 Customer c3=new Customer(103,"Ankit","LKO","77777");
	 cust.add(c1);
	 cust.add(c2);
	 cust.add(c3);
	 }
	 @Autowired
	 @Lazy
	 private RestTemplate restTemplate; // for make connection or two application can talk to each other
	/***
	 * 
	 * @return list of customers
	 */
	public List<Customer> allCustomer()
	{
		return this.cust;
	}
	/***
	 * 
	 * @param id
	 * @return single customers details
	 */
	public ResponseEntity<Customer> getCustomer(int id)
	{
		Customer cust1=null;
		Customer c2=null;
		List<Customer> cust=this.allCustomer();
		for(Customer c: cust)
		{
			if(c.getCustId()==id)
			{
				cust1=c;
				c2=c;
				break;
			}
		}
		try
		{
			// calling another application's api
			List<Accounts> acc= this.restTemplate.getForObject(url + id, List.class);
			if(acc!=null) {	
			cust1.setAccount(acc);
			return ResponseEntity.status(HttpStatus.OK).body(cust1);
			}
			else
			{
				List<Accounts> dummy=new ArrayList<>();
			cust1.setAccount(dummy);
			return ResponseEntity.status(HttpStatus.OK).body(cust1);
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	/***
	 * 
	 * @param c
	 * @return
	 */
	public ResponseEntity<String> registerCustomer(Customer c)
	{
		cust.add(c);
		return ResponseEntity.status(HttpStatus.CREATED).body("Customer created Successfully");
	}
	
	//update the customers details
	public ResponseEntity<String> updateCustomer(int id, Customer c)
	{
		for(Customer c1:cust)
		{
			if(c1.getCustId()==id)
			{
				c1.setName(c.getName());
				c1.setAddress(c.getAddress());
				c1.setPhoneNo(c.getPhoneNo());
				break;
			}
			
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Customer updated Successfully");
	}
	/***
	 * 
	 * Delete the customers details
	 * @param id
	 * @return
	 */
	public ResponseEntity<String> deleteCustomer(int id)
	{
		try
		{
			for(Customer c: cust)
			{
				if(c.getCustId()==id)
				{
					cust.remove(c);
					this.restTemplate.delete(url+"delete/"+id);
					break;
				}
			}
			return ResponseEntity.status(HttpStatus.CREATED).body("Customer Deleted Successfully");
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			return ResponseEntity.of(Optional.of("User is Invalid"));
			
		}
	}

}
