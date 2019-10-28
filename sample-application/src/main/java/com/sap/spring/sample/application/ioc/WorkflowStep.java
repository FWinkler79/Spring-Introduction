package com.sap.spring.sample.application.ioc;

/**
 * Abstract superclass of all workflow steps that 
 * can be used with {@link WorkflowEngine}.
 */
public abstract class WorkflowStep {
  protected WorkflowEngine engine;
  protected String name;
  
  public WorkflowStep(String name) {
    this.name = name;
  }
  
  // dependency injection! The framework / workflow engine injects itself
  // into every step.
  public void init(WorkflowEngine engine) {
    this.engine = engine;
  }
  
  // basic logic (print statements) that is the same for
  // all workflow steps is outsourced to this superclass.
  void run() {
    System.out.println("Executing Workflow-Step named: " + name);
    process(); // calling the actual implementation  from the subclass (Hollywood principle).
    System.out.println("Workflow-Step " + name + " finished");
    System.out.println();
  }
  
  //subclasses need to implement this specifically.
  public abstract void process();
}
