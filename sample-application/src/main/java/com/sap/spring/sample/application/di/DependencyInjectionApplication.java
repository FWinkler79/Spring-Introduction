package com.sap.spring.sample.application.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext applicationContext = SpringApplication.run(DependencyInjectionApplication.class, args);
		
	  CustomerService service = applicationContext.getBean(CustomerService.class);
	  service.execute(); // should not throw any exceptions.
	  System.out.println("Customer Service has all the beans it needs!");
	}
}
