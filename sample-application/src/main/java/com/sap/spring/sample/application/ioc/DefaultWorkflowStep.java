package com.sap.spring.sample.application.ioc;

public class DefaultWorkflowStep extends WorkflowStep {

  public DefaultWorkflowStep(String name) {
    super(name);
  }

  @Override
  public void process() {
    System.out.println("This is step " + name + " doing some processing!");
    System.out.println("I am run by workflow engine: " + engine.getEngineName());
  }
}
