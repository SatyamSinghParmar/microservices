package com.learn.microservices.restfulservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class RestFulServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFulServicesApplication.class, args);
	}

}

