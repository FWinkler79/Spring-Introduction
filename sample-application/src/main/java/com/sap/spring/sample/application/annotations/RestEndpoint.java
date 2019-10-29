package com.sap.spring.sample.application.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoint {

  @Value("${com.sap.custom.config.properties.title}")
  private String title;
  
  @Value("${com.sap.custom.config.properties.subTitle}")
  private String subTitle;

  @GetMapping (path = "/title/{addition}")
  public String getTitle(@PathVariable String addition) {
    String response =  title + " - " + subTitle + "<BR>Your addition was: " + addition;
    return response;    
  }
  
}
