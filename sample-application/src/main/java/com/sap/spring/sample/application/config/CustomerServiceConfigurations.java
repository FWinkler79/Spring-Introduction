package com.sap.spring.sample.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerServiceConfigurations {
  
  @Bean
  Customer customerBean() {
    return new Customer("Alan Turing");
  }
  
  @Bean
  CustomerService customerServiceBean(HttpLayer httpLayer, Logger logger, ThreadScheduler scheduler) {
      CustomerService service = new CustomerService(httpLayer);
      service.setLogger(logger);
      service.setScheduler(scheduler);
      return service;
  }
}
