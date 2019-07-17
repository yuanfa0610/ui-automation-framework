package com.company.product.test.automation.ui.framework.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePageComponentImpl<T extends BasePageComponentImpl<T>> extends LoadableComponent<T> implements BasePageComponent {

    protected WebDriver driver;

    private static final long DEFAULT_EXPLICIT_WAIT_TIME = 10000L;
    private static final String SCROLL_ELEMENT_TO_TOP_JAVASCRIPT = "arguments[0].scrollIntoView();";
    private static final String IS_ELEMENT_LOADED_JAVASCRIPT = "return arguments[0].complete "
                                                             + "&& typeof arguments[0].naturalWidth != 'undefined' "
                                                             + "&& arguments[0].naturalWidth > 0";

    public BasePageComponentImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String getElementText(WebElement element) {
        return element.getText();
    }

    @Override
    public void setElementText(WebElement element, String text) {
        scrollElementIntoView(element);
        element.sendKeys(text);
    }

    @Override
    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    @Override
    public void selectElement(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    @Override
    public void unSelectElement(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }

    @Override
    public String getElementAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    @Override
    public void clickElement(WebElement element) {
        waitForElementToBeVisible(element);
        scrollElementIntoView(element);
        waitForElementToBeClickable(element);
        element.click();
    }

    @Override
    public void mouseOverElement(WebElement element) {
        Actions builder = new Actions(driver);
        Action mouseOverElement = builder.moveToElement(element).build();
        mouseOverElement.perform();
    }

    @Override
    public void scrollElementIntoView(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(SCROLL_ELEMENT_TO_TOP_JAVASCRIPT);
    }

    @Override
    public WebElement getSelectedOptionFromElement(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption();
    }

    @Override
    public List<WebElement> getAllOptionsFromElement(WebElement element) {
        Select select = new Select(element);
        return select.getOptions();
    }

    @Override
    public void selectOptionFromElement(WebElement element, String optionText) {
        Select select = new Select(element);
        select.selectByVisibleText(optionText);
    }

    @Override
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    @Override
    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    @Override
    public boolean isElementLoaded(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return (Boolean) javascriptExecutor.executeScript(IS_ELEMENT_LOADED_JAVASCRIPT);
    }

    @Override
    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void waitForElementToBeVisible(WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds * 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void waitForElementToBeInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    @Override
    public void waitForElementToBeInvisible(WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds * 1000);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    @Override
    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public void waitForElementToBeClickable(WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds * 1000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
