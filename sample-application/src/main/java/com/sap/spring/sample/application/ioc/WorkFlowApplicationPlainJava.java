package com.sap.spring.sample.application.ioc;

public class WorkFlowApplicationPlainJava {

  public static void main(String[] args) {
    
    // We need to do all the wiring and object creation ourselves!
    // That couple our application tightly to the actual implementation
    // classes.
    WorkflowStep step1 = new DefaultWorkflowStep("ONE");
    WorkflowStep step2 = new DefaultWorkflowStep("TWO");
    WorkflowStep step3 = new DefaultWorkflowStep("THREE");
    
    WorkflowEngine engine = new WorkflowEngine(step1, step2, step3);
    engine.executeWorkflow();
  }
}
