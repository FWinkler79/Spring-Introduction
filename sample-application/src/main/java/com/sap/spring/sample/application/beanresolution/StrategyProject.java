package com.sap.spring.sample.application.beanresolution;

public class StrategyProject {

  private Architect chiefArchitect;
  
  public StrategyProject(Architect chiefArchitect) {
    this.chiefArchitect = chiefArchitect;
  }

  @Override
  public String toString() {
    return "StrategyProject [chiefArchitect=" + chiefArchitect + "]";
  }
}
