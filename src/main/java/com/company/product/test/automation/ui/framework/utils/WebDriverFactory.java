package com.company.product.test.automation.ui.framework.utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

  private static final Logger LOG = LoggerFactory.getLogger(WebDriverFactory.class);


  /**
   * Get remote web driver based on given browser name in automation configuration
   * @param automationConfiguration automation configuration that has browser name
   * @return remote web driver
   * @throws InvalidBrowserNameException
   */
  public static RemoteWebDriver getWebDriver(AutomationConfiguration automationConfiguration) throws InvalidBrowserNameException {
    String browserName = automationConfiguration.getBrowserName();
    String webDriverPath = automationConfiguration.getWebDriverPath();

    if (StringUtils.isBlank(browserName)) {
      LOG.debug("No browser name found. Using Chrome as default option");
      return new ChromeDriver();
    }

    RemoteWebDriver webDriver = null;
    try {
      switch (browserName) {
        case BrowserNames.CHROME_BROWSER:
          System.setProperty("webdriver.chrome.driver", webDriverPath + "/chromedriver");
          webDriver = new ChromeDriver();
          break;
        case BrowserNames.FIREFOX_BROWSER:
          System.setProperty("webdriver.gecko.driver", webDriverPath + "/geckodriver");
          FirefoxOptions options = new FirefoxOptions();
          options.setCapability("marionette", false);
          webDriver = new FirefoxDriver(options);
          break;
        case BrowserNames.INTERNET_EXPLORER_BROWSER:
          webDriver = new InternetExplorerDriver();
          break;
        case BrowserNames.EDGE_BROWSER:
          webDriver = new EdgeDriver();
          break;
        case BrowserNames.SAFARI_BROWSER:
          webDriver = new SafariDriver();
          break;
      }

    } catch (Exception exception) {
      LOG.error(exception.getMessage());
    }

    if (webDriver == null) {
      LOG.error("Given browser name is invalid");
      throw new InvalidBrowserNameException("Invalid browser name is provided");
    }

    LOG.info("Returning web driver");
    return webDriver;
  }

  /**
   * Initialize web driver with given configuration
   * @param automationConfiguration automation configuration
   * @param driver web driver to initialize
   */
  public static void initializeWebDriver(AutomationConfiguration automationConfiguration, RemoteWebDriver driver) {
    long implicitWaitTime = automationConfiguration.getImplicitWaitTime();

    driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

}