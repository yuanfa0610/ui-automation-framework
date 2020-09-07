package com.company.test.automation.ui.framework.pages;

import com.company.test.automation.ui.framework.actions.BasePageComponentImpl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverIOHomePage extends BasePageComponentImpl<WebDriverIOHomePage> {


    private final static Logger LOGGER = Logger.getLogger(WebDriverIOHomePage.class.getName());

    private static final String PAGE_URL_TEXT = "webdriver.io";

    private final WebDriver driver;
    private boolean isPageLoaded;

    @FindBy(id = "search_input_react")
    WebElement searchInput;

    @FindBy(css = "#algolia-autocomplete-listbox-0")
    WebElement autoCompleteSection;

    public WebDriverIOHomePage(WebDriver driver) {
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
                "WebDriver home page not loaded");
        LOGGER.log(Level.INFO,"WebDriver Home page loaded");
    }

    /**
     * Enter content in search input
     * @param content content to enter
     */
    public void enterContentInSearchInput(String content) {
        waitForElementToBeVisible(searchInput);
        searchInput.sendKeys(content);
        LOGGER.log(Level.INFO, "Content entered in search input");
    }

    /**
     * Check if the auto completed section is displayed
     * @return true if the auto completed section is displayed
     */
    public boolean autoCompleteSectionDisplayed() {
        return waitForElementToBeVisible(autoCompleteSection, 10);
    }

    /**
     * Search some content in search input
     * @param content content to search
     */
    public void searchContent(String content) {
        enterContentInSearchInput(content);
        waitForElementToBeVisible(autoCompleteSection);
        searchInput.sendKeys(Keys.ENTER);
        LOGGER.log(Level.INFO, "Search completed");
    }
}
