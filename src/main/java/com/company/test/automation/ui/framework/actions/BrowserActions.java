package com.company.test.automation.ui.framework.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class BrowserActions {

    /**
     * Click forward arrow in browser
     */
    public static void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }

    /**
     * Click backward arrow in browser
     */
    public static void navigateBackward(WebDriver driver) {
        driver.navigate().back();
    }

    /**
     * Refresh the browser
     */
    public static void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    /**
     * Maximize the browser window
     */
    public static void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }

    /**
     * Switch to iFrame
     * @param iframe iFrame to switch to
     */
    public static void switchToFrame(WebDriver driver, WebElement iframe) {
        driver.switchTo().frame(iframe);
    }

    /**
     * Switch back to patient iFrame
     */
    public static void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    /**
     * Switch back to main iFame
     */
    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    /**
     * Get a set of all opening window handle IDs
     * @return a set of window handle IDs
     */
    public static Set<String> getWindowHandles(WebDriver driver) {
        return driver.getWindowHandles();
    }

    /**
     * Get current window handle ID
     * @return current window handle ID
     */
    public static String getCurrentWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    /**
     * Switch to target window
     * @param windowHandleID ID of the target window
     */
    public static void switchToWindow(WebDriver driver, String windowHandleID) {
        driver.switchTo().window(windowHandleID);
    }

    /**
     * Execute given script in browser
     * @param script script to execute
     */
    public static void executeScript(WebDriver driver, String script) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(script);
    }
}
