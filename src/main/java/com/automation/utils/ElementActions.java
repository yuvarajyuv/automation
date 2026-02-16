package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Wrapper class for common element actions with simple retry logic.
 *
 * Example usage in a page class:
 *   private ElementActions actions;
 *
 *   public LoginPage(WebDriver driver) {
 *       this.driver = driver;
 *       this.actions = new ElementActions(driver);
 *   }
 *
 *   public void clickOnLoginButton() {
 *       actions.click(loginButtonLocator);
 *   }
 */
public class ElementActions {

    private final WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on an element located by the given By locator.
     * If click() fails the first time, it retries once more inside catch block.
     */
    public void click(By locator) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                WebElement element = driver.findElement(locator);
                element.click();
                return; // success
            } catch (Exception e) {
                attempts++;
                if (attempts == 2) {
                    // After retry also fails, rethrow or log as needed
                    throw e;
                }
            }
        }
    }

    /**
     * Sends keys to an element with a simple retry mechanism.
     */
    public void type(By locator, String text) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                WebElement element = driver.findElement(locator);
                element.clear();
                element.sendKeys(text);
                return;
            } catch (Exception e) {
                attempts++;
                if (attempts == 2) {
                    throw e;
                }
            }
        }
    }
}

