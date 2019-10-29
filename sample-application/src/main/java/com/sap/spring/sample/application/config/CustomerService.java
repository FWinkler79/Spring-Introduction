package com.sap.spring.sample.application.config;

public class CustomerService {
  
  private Logger logger;
  
  private HttpLayer httpLayer;
  
  private ThreadScheduler scheduler;
  
  // constructor injection
  public CustomerService(HttpLayer httpLayer) {
    this.httpLayer = httpLayer;
  }

  public ThreadScheduler getScheduler() {
    return scheduler;
  }

  // setter injection
  public void setScheduler(ThreadScheduler scheduler) {
    this.scheduler = scheduler;
  }
  
  public void setLogger(Logger logger) {
    this.logger = logger;
  }
  
  public void execute() {
     assert(logger != null);
     assert(httpLayer != null);
     assert(scheduler != null);
  }
}
