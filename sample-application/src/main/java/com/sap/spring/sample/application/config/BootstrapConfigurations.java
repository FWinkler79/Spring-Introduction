package com.sap.spring.sample.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootstrapConfigurations {

  @Bean
  HttpLayer httpLayerBean() {
    return new HttpLayer();
  }
  
  @Bean
  Logger loggerBean() {
    return new Logger();
  }
  
  @Bean 
  ThreadScheduler schedulerBean() {
    return new ThreadScheduler();
  }
}
