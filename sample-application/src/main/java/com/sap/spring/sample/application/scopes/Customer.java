package com.sap.spring.sample.application.scopes;

public class Customer {
  
  private String name;
  private Address address1;
  private Address address2;
    
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

  public Address getAddress1() {
    return address1;
  }

  public void setAddress1(Address address1) {
    this.address1 = address1;
  }

  public Address getAddress2() {
    return address2;
  }

  public void setAddress2(Address address2) {
    this.address2 = address2;
  }

  @Override
  public String toString() {
    return "Customer [name=" + name + ", address1=" + address1 + ", address2=" + address2 + "]";
  }
}
