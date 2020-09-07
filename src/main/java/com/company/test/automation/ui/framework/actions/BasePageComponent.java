package com.company.test.automation.ui.framework.actions;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface BasePageComponent {

    /**
     * Get the text displayed on element
     * @param element web element with text
     * @return text displayed
     */
    String getElementText(WebElement element);

    /**
     * Set text on element
     * @param element web element to set text on
     * @param text text to set
     */
    void setElementText(WebElement element, String text);

    /**
     * Check if the element is selected
     * @param element web element to check
     * @return true if element is selected
     */
    boolean isElementSelected(WebElement element);

    /**
     * Select element
     * @param element web element to be selected
     */
    void selectElement(WebElement element);

    /**
     * Un-Select element
     * @param element web element to be unselected
     */
    void unSelectElement(WebElement element);

    /**
     * Get the value of element's specified attribute
     * @param element web element with the expected attribute
     * @param attribute expected attribute to get
     * @return value of the attribute
     */
    String getElementAttribute(WebElement element, String attribute);

    /**
     * Click the element
     * @param element element to be clicked
     */
    void clickElement(WebElement element);

    /**
     * Move mouse over the element
     * @param element web element to move the mouse on
     */
    void mouseOverElement(WebElement element);

    /**
     * Scroll the element into view
     * @param element target web element
     */
    void scrollElementIntoView(WebElement element);

    /**
     * Get selected option from element
     * @param element web element with options
     * @return web element of selected option
     */
    WebElement getSelectedOptionFromElement(WebElement element);

    /**
     * Get all options from element
     * @param element web element with options
     * @return list of options' web elements
     */
    List<WebElement> getAllOptionsFromElement(WebElement element);

    /**
     * Select option from element
     * @param element web element with options
     * @param optionText text of option to select
     */
    void selectOptionFromElement(WebElement element, String optionText);


    /**
     * Check if element is displayed
     * @param element web element to check
     * @return true if the element is displayed
     */
    boolean isElementPresent(WebElement element);

    /**
     * Check if element is enabled
     * @param element web element to check
     * @return true if the element is enabled
     */
    boolean isElementEnabled(WebElement element);

    /**
     * Check if element is loaded
     * @param element web element to check
     * @return true if the element is loaded
     */
    boolean isElementLoaded(WebElement element);

    /**
     * Wait for web element to be visible
     * @param element web element to wait
     * @return true if element is visible
     */
    boolean waitForElementToBeVisible(WebElement element);

    /**
     * Wait for web element to be visible in given seconds
     * @param element web element to wait
     * @param seconds maximum seconds to wait
     * @return true if element is visible
     */
    boolean waitForElementToBeVisible(WebElement element, long seconds);

    /**
     * Wait for web element to be invisible
     * @param element web element to wait
     * @return true if element is visible
     */
    boolean waitForElementToBeInvisible(WebElement element);

    /**
     * Wait for web element to be invisible in given seconds
     * @param element web element to wait
     * @param seconds maximum seconds to wait
     * @return true if element is visible
     */
    boolean waitForElementToBeInvisible(WebElement element, long seconds);

    /**
     * Wait for web element to be clickable
     * @param element web element to wait
     * @return true if element is visible
     */
    boolean waitForElementToBeClickable(WebElement element);

    /**
     * Wait for web element to be clickable
     * @param element web element to wait
     * @param seconds maximum seconds to wait
     * @return true if element is visible
     */
    boolean waitForElementToBeClickable(WebElement element, long seconds);


}
