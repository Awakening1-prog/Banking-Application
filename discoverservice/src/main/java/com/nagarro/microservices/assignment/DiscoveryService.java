package com.nagarro.microservices.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryService 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(DiscoveryService.class,args);
        System.out.println( "Hello World!" );
    }
}
