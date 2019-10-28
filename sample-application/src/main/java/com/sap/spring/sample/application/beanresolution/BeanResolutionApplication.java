package com.sap.spring.sample.application.beanresolution;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class BeanResolutionApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext applicationContext = SpringApplication.run(BeanResolutionApplication.class, args);
		
	  // Easy to resolve - there is only one bean with that unique type.
	  UniqueType ut  = applicationContext.getBean(UniqueType.class);
	  
	  // Using the name qualifier to get the bean instance
	  Architect developmentArchitect = (Architect)applicationContext.getBean("DevelopmentArchitect");
	  System.out.println(developmentArchitect);
	  
	  StrategyProject project = applicationContext.getBean(StrategyProject.class);
	  System.out.println("Project: " + project);
	  
	  // "Collect" all beans of type Architect into an array.
	  // Bean instances will be ordered according to @Order annotation.
	  Architect[] architects = (Architect[]) applicationContext.getBean("allArchitects");
	  Arrays.stream(architects).forEach(System.out::println);
	  
	  // Equivalent:
	  Map<String, Architect> sameArchitects = applicationContext.getBeansOfType(Architect.class);
	  sameArchitects.entrySet().stream().forEach(System.out::println);
	}

	/// TYPE
	
	@Bean
	UniqueType uniqueTypeBean() {
	  return new UniqueType();
	}
	
	/// QUALIFIER
	
	@Bean(name = "DevelopmentArchitect")
	Architect youCanNameThisWhateverYouLike() {
	  return new Architect("John Developer", false);
	}
	
	/// ORDERING
	
	@Bean
	Architect[] allArchitects(Architect[] architects) {
	  return architects;
	}
	
	@Bean
	@Order(Ordered.LOWEST_PRECEDENCE)
	Architect architect() {
	  return new Architect("John Doe", false);
	}
	
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
  Architect chiefArchitect() {
    return new Architect("John Chief", true);
  }
	
	@Bean
	StrategyProject strategicProject(@Qualifier("chiefArchitect") Architect chief) {
	  return new StrategyProject(chief);
	}
}
