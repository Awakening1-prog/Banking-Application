package com.nagarro.microservices.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 
 * @author utkarshsrivastava01
 * creating fallback API , it will hit automatic whenever any service goes down.
 */
@RestController
public class FallbackController {
	
	@GetMapping("/customerServiceFallback")
	public String customerServiceFallback()
	{
		return "Customer Service is down at this time";
	}
	
	@GetMapping("/accountServiceFallback")
	public String accountServiceFallback()
	{
		return "Account Service is down at this time";
	}
}
