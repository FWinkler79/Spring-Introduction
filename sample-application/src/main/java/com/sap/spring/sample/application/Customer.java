package com.sap.spring.sample.application;

public class Customer {
  
  private String name;
   
  public Customer(String name) {
    this.name = name;
  }

  public Customer() {
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
    return "Customer [name=" + name + "]";
  }
}
