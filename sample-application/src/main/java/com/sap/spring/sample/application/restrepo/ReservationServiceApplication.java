package com.sap.spring.sample.application.restrepo;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import lombok.extern.slf4j.Slf4j;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Slf4j
@SpringBootApplication//(exclude = ContextFunctionCatalogAutoConfiguration.class) // <-- use this to disable Cloud Functions altogether.
public class ReservationServiceApplication {

  @Autowired 
  ReservationRepository reservationRepository;
  
  @Bean
  CommandLineRunner runOnStartup() {
    return strings -> {
        log.info("Saving initial reservations.");
        
        Stream.of("Carl", "James", "Susan", "Jack")
              .forEach( name -> {
                reservationRepository.save(new Reservation(name)); 
              });
    };
  }
  
  public static void main(String[] args) {
    SpringApplication.run(ReservationServiceApplication.class, args);
  }
  
  @Bean
  public Scheduler jdbcScheduler() {
    return Schedulers.boundedElastic();
  }

  @Bean
  public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
    return new TransactionTemplate(transactionManager);
  }
}
