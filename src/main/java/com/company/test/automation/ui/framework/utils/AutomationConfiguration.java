package com.company.test.automation.ui.framework.utils;

public class AutomationConfiguration {

  private String browserName;

  private String webDriverPath;

  private long implicitWaitTime;

  public String getBrowserName() {
    return this.browserName;
  }

  public void setBrowserName(String browserName) {
    this.browserName = browserName;
  }

  public String getWebDriverPath() {
    return webDriverPath;
  }

  public void setWebDriverPath(String webDriverPath) {
    this.webDriverPath = webDriverPath;
  }

  public long getImplicitWaitTime() {
    return implicitWaitTime;
  }

  public void setImplicitWaitTime(long implicitWaitTime) {
    this.implicitWaitTime = implicitWaitTime;
  }
}