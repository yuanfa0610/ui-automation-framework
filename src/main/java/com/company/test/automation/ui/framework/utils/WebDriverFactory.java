package com.company.test.automation.ui.framework.utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
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
    String nodeHost = automationConfiguration.getNodeHost();
    String nodePort = automationConfiguration.getNodePort();
    String browserName = automationConfiguration.getBrowserName();
    String platformName = automationConfiguration.getPlatformName();

    String nodeUrl = generateNodeUrl(nodeHost, nodePort);

    if (StringUtils.isBlank(browserName)) {
      LOG.debug("No browser name found. Using Chrome as default option");
      return new ChromeDriver();
    }

    RemoteWebDriver webDriver = null;
    DesiredCapabilities capability = null;
    try {
      switch (browserName) {
        case BrowserNames.CHROME_BROWSER:
          capability = DesiredCapabilities.chrome();
          capability.setBrowserName(browserName);
          capability.setPlatform(Platform.fromString(platformName));
          break;
        case BrowserNames.FIREFOX_BROWSER:
          capability = DesiredCapabilities.firefox();
          capability.setBrowserName(browserName);
          capability.setPlatform(Platform.fromString(platformName));
          break;
        case BrowserNames.INTERNET_EXPLORER_BROWSER:
          capability = DesiredCapabilities.internetExplorer();
          capability.setBrowserName(browserName);
          capability.setPlatform(Platform.fromString(platformName));
          break;
        case BrowserNames.EDGE_BROWSER:
          capability = DesiredCapabilities.edge();
          capability.setBrowserName(browserName);
          capability.setPlatform(Platform.fromString(platformName));
          break;
        case BrowserNames.SAFARI_BROWSER:
          capability = DesiredCapabilities.safari();
          capability.setBrowserName(browserName);
          capability.setPlatform(Platform.fromString(platformName));
          break;
      }

      webDriver = new RemoteWebDriver(new URL(nodeUrl), capability);

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

  /**
   * Generate node URL based on given host and port
   * @param nodeHost host to connect to
   * @param nodePort port to connect to
   * @return node URL
   */
  private static String generateNodeUrl(String nodeHost, String nodePort) {
    String nodeUrl = "http://" + nodeHost + ":" + nodePort + "/wd/hub";
    return nodeUrl;
  }

}