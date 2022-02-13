package com.nagarro.microservices.CustomerManagementService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.CustomerManagementService.model.Customer;
import com.nagarro.microservices.CustomerManagementService.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("customers/register")
	public  ResponseEntity<String> registerCustomers(@RequestBody Customer c)

	{
		
		return this.customerService.registerCustomer(c);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomer()
	{
		
		return this.customerService.allCustomer();
	}
	
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id)
	{
		return this.customerService.getCustomer(id);
	}
	
	@PutMapping("customers/update/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable("id") int id ,@RequestBody Customer c)
	{
		return this.customerService.updateCustomer(id,c);
	}
	@DeleteMapping("customers/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id)
	{
		return this.customerService.deleteCustomer(id);
		
	}
}
