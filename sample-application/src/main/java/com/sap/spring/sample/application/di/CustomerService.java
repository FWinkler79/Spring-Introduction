package com.sap.spring.sample.application.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  
  //Field injection
  @Autowired
  private Logger logger;
  
  private HttpLayer httpLayer;
  
  private ThreadScheduler scheduler;
  
  public CustomerService(HttpLayer httpLayer) {
    this.httpLayer = httpLayer;
  }

  public ThreadScheduler getScheduler() {
    return scheduler;
  }

  @Autowired
  public void setScheduler(ThreadScheduler scheduler) {
    this.scheduler = scheduler;
  }
  
  public void execute() {
     assert(logger != null);
     assert(httpLayer != null);
     assert(scheduler != null);
  }
}
