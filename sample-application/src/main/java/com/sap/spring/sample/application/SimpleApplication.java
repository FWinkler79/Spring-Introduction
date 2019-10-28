package com.sap.spring.sample.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext applicationContext = SpringApplication.run(SimpleApplication.class, args);
		
	  Customer customer = applicationContext.getBean(Customer.class);
	  System.out.println("Customer: " + customer);
	}

	@Bean
	Customer customer() {
	  return new Customer("Alan Turing");
	}
}
