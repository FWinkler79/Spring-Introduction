package com.sap.spring.sample.application.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigurationApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigurationApplication.class, args);
		
	  Customer customer = applicationContext.getBean(Customer.class);
	  CustomerService customerService = applicationContext.getBean(CustomerService.class);
	  System.out.println("Customer:        " + customer);
	  System.out.println("CustomerService: " + customerService);
	}
}
