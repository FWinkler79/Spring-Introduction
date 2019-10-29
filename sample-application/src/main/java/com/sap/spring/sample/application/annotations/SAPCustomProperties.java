package com.sap.spring.sample.application.annotations;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties(prefix = "com.sap.custom.config.properties")
public class SAPCustomProperties {

  @NotBlank
  private String title;
  
  @Length(max = 50, min = 5)
  private String subTitle;
  
  @Min(1025)
  @Max(65536)
  private int port;
  
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  @Override
  public String toString() {
    return "SAPCustomProperties [title=" + title + ", subTitle=" + subTitle + ", port=" + port + "]";
  }
}
