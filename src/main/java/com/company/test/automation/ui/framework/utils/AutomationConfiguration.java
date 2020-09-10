package com.company.test.automation.ui.framework.utils;

import org.testng.ITestContext;
import org.testng.xml.XmlTest;

public class AutomationConfiguration {

  private String nodeHost;

  private String nodePort;

  private String browserName;

  private String platformName;

  private long implicitWaitTime;

  public AutomationConfiguration(ITestContext context) {
    XmlTest xmlTest = context.getCurrentXmlTest();
    this.setNodeHost(xmlTest.getParameter("nodeHost"));
    this.setNodePort(xmlTest.getParameter("nodePort"));
    this.setBrowserName(xmlTest.getParameter("browserName"));
    this.setPlatformName(xmlTest.getParameter("platformName"));
    this.setImplicitWaitTime(5);

  }

  public String getNodeHost() {
    return nodeHost;
  }

  public void setNodeHost(String nodeHost) {
    this.nodeHost = nodeHost;
  }

  public String getNodePort() {
    return nodePort;
  }

  public void setNodePort(String nodePort) {
    this.nodePort = nodePort;
  }

  public String getBrowserName() {
    return this.browserName;
  }

  public void setBrowserName(String browserName) {
    this.browserName = browserName;
  }

  public String getPlatformName() {
    return platformName;
  }

  public void setPlatformName(String platformName) {
    this.platformName = platformName;
  }

  public long getImplicitWaitTime() {
    return implicitWaitTime;
  }

  public void setImplicitWaitTime(long implicitWaitTime) {
    this.implicitWaitTime = implicitWaitTime;
  }
}