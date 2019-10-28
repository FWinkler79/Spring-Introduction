package com.sap.spring.sample.application.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sap.spring.sample.application.SimpleApplication;

@SpringBootApplication
public class WorkFlowApplicationSpring {

  public static void main(String[] args) {
      ConfigurableApplicationContext applicationContext = SpringApplication.run(SimpleApplication.class, args);
      
      // We let spring assemble our workflow engine
      // and eventually, we just tell it to execute the workflow.
      WorkflowEngine workflowEngine = applicationContext.getBean(WorkflowEngine.class);
      workflowEngine.executeWorkflow();
  }
  
  
  // We still define the beans (and need to know the implementation classes 
  // of the workflow steps, but: what if we could move that somewhere outside of 
  // this app?! --> Configurations
  @Bean
  WorkflowStep step1() {
    return new DefaultWorkflowStep("ONE");
  }
  
  @Bean
  WorkflowStep step2() {
    return new DefaultWorkflowStep("TWO");
  }
  
  @Bean
  WorkflowStep step3() {
    return new DefaultWorkflowStep("THREE");
  }
  
  @Bean
  WorkflowEngine workflowEngine(WorkflowStep step1, WorkflowStep step2, WorkflowStep step3) {
    return new WorkflowEngine(step1, step2, step3);
  }
}
