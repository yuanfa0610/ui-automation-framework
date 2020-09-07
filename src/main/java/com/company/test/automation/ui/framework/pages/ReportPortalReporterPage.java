package com.company.test.automation.ui.framework.pages;

import com.company.test.automation.ui.framework.actions.BasePageComponentImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportPortalReporterPage extends BasePageComponentImpl<ReportPortalReporterPage> {

    private final static Logger LOGGER = Logger.getLogger(ReportPortalReporterPage.class.getName());

    private static final String PAGE_URL_TEXT = "webdriver.io/docs/wdio-reportportal-reporter.html";

    private final WebDriver driver;
    private boolean isPageLoaded;

    @FindBy(className = "postHeaderTitle")
    WebElement postHeaderTitle;

    public ReportPortalReporterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        this.isPageLoaded = true;
        LOGGER.log(Level.INFO, "Loading page: " + this.driver.getCurrentUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        String url = this.driver.getCurrentUrl();
        Assert.assertTrue(this.isPageLoaded && url.contains(PAGE_URL_TEXT),
                "ReportPortalReporter home page not loaded");
        LOGGER.log(Level.INFO,"ReportPortalReporter Home page loaded");
    }

    /**
     * Get post header title
     * @return post header title
     */
    public String getPostHeaderTitle() {
        return postHeaderTitle.getText();
    }
}

