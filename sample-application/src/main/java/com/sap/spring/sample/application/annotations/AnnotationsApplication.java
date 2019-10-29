package com.sap.spring.sample.application.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AnnotationsApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext applicationContext = SpringApplication.run(AnnotationsApplication.class, args);
	
	  SAPCustomProperties properties = applicationContext.getBean(SAPCustomProperties.class);
	  System.out.println("Properties from file: " + properties);
	}
}
