package com.company.test.automation.ui.framework.testscripts;

import com.company.test.automation.ui.framework.pages.ReportPortalReporterPage;
import com.company.test.automation.ui.framework.pages.WebDriverIOHomePage;
import com.company.test.automation.ui.framework.utils.AutomationConfiguration;
import com.company.test.automation.ui.framework.utils.WebDriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SampleSuite1 {

    private final static Logger LOGGER = Logger.getLogger(SampleSuite1.class.getName());

    private static RemoteWebDriver driver;
    private AutomationConfiguration automationConfiguration;

    private static String WEBDRIVER_PAGE_URL = "https://webdriver.io/";

    @BeforeTest
    public void init(ITestContext context) {
        automationConfiguration = new AutomationConfiguration(context);
    }

    @Test
    public void sampleSuite1Scenario1() {

        try {

            LOGGER.log(Level.INFO, "Sample Suite 1 Scenario 1 Started");

            driver = WebDriverFactory.getWebDriver(automationConfiguration);

            WebDriverFactory.initializeWebDriver(automationConfiguration, driver);

            driver.get(WEBDRIVER_PAGE_URL);

            WebDriverIOHomePage webDriverIOHomePage = new WebDriverIOHomePage(driver).get();

            webDriverIOHomePage.enterContentInSearchInput("API");

            Assert.assertTrue(webDriverIOHomePage.autoCompleteSectionDisplayed(), "Auto complete section doesn't show up");


        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Some unexpected error is happening during test");

        } finally {

            driver.quit();
            LOGGER.log(Level.INFO, "Sample Suite 1 Scenario 1 completed");
        }

    }

    @Test
    public void sampleSuite1Scenario2() {

        try {

            LOGGER.log(Level.INFO, "Sample Suite 1 Scenario 2 Started");

            driver = WebDriverFactory.getWebDriver(automationConfiguration);

            WebDriverFactory.initializeWebDriver(automationConfiguration, driver);

            driver.get(WEBDRIVER_PAGE_URL);

            WebDriverIOHomePage webDriverIOHomePage = new WebDriverIOHomePage(driver).get();

            webDriverIOHomePage.searchContent("API");

            ReportPortalReporterPage reportPortalReporterPage = new ReportPortalReporterPage(driver).get();

            Assert.assertEquals(reportPortalReporterPage.getPostHeaderTitle(), "Report Portal Reporter", "Report Portal Report page is not displayed");


        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Some unexpected error is happening during test");

        } finally {

            driver.quit();
            LOGGER.log(Level.INFO, "Sample Suite 1 Scenario 2 completed");
        }

    }
}
