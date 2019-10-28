package com.sap.spring.sample.application.ioc;

/**
 * A simple workflow engine with customizable steps. 
 */
public class WorkflowEngine {

  private static final String name = "SAP WorkflowEngine";
  
  private WorkflowStep step1;
  private WorkflowStep step2;
  private WorkflowStep step3;
  
  // Dependency injection! The workflow engine gets the steps injected
  // that make up the actual work flow. Later it just executes them in turn.
  public WorkflowEngine(WorkflowStep step1, WorkflowStep step2, WorkflowStep step3) {
    this.step1 = step1;
    this.step2 = step2;
    this.step3 = step3;
    
    initializeSteps(); // important!
  }
  
  // Dependency injection! The workflow engine injects itself 
  // into each step!
  private void initializeSteps() {
    step1.init(this);
    step2.init(this);
    step3.init(this);
  }
   
  // IoC! the framework calls each step in the order
  // defined in the engine.
  public void executeWorkflow() {
    step1.run();
    step2.run();
    step3.run();
  }
  
  public String getEngineName() {
    return name;
  }
}
