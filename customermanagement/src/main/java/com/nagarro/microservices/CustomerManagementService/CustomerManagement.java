package com.nagarro.microservices.CustomerManagementService;

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
public class CustomerManagement 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(CustomerManagement.class,args);
        System.out.println( "Hello World!" );
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
    	return new RestTemplate();
    }
}
