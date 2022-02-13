package com.nagarro.microservices.AccountManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class AccountManagement 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(AccountManagement.class,args);
        System.out.println( "Hello World!" );
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
    	return new RestTemplate();
    }
}
