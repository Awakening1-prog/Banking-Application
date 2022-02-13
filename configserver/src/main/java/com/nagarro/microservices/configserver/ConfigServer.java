package com.nagarro.microservices.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServer 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ConfigServer.class,args);
        System.out.println( "Hello World!" );
    }
}
