package com.sap.spring.sample.application.beanresolution;

public class Architect {
  
  private String name;
  private boolean isChief;
   
  public Architect(String name, boolean isChief) {
    this.name = name;
    this.isChief = isChief;
  }

  public Architect() {
    this.name = "N/A";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Architect [name=" + name + ", isChief =" + isChief + "]";
  }
}
