package com.sap.spring.sample.application.scopes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class ScopingApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext applicationContext = SpringApplication.run(ScopingApplication.class, args);
		
	  Customer aCustomer = (Customer) applicationContext.getBean("addressableCustomer");
		System.out.println("A Customer: " + aCustomer);
		
		Address address = applicationContext.getBean(Address.class);
		System.out.println("Yet another Address: " + address);
	}

	@Bean
	Customer addressableCustomer(Address address1, Address address2) {
	  Customer customer = new Customer("Alan Turing");
	  customer.setAddress1(address1);
	  customer.setAddress2(address2);
	  return customer;
	}
	
	@Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	Address address() {
    if(Math.random() > .5) {
      return new Address("Dietmar-Hopp-Allee 16", "69190 Walldorf"); 
    }
    else {
      return new Address("Hasso-Plattner-Ring", "69190 Walldorf");
    } 
	}
}
