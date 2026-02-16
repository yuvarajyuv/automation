package com.automation.pages;

import com.automation.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Example Page Object class to hold locators (xpaths) and related actions.
 *
 * - This class contains all the xpaths / locators for a sample "Login" page.
 * - Each locator has a corresponding method that uses ElementActions with try-catch + retry.
 * - In your main script / test class, you will create an object of this page and call these methods.
 */
public class LoginPage {

    private final WebDriver driver;
    private final ElementActions actions;

    // ====== All XPaths / locators go here ======
    // NOTE: Replace these sample xpaths with your real application xpaths later.
    private final By usernameInput = By.xpath("//input[@id='username']");
    private final By passwordInput = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//button[@id='login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

    // ====== Getter-like methods / action methods using try-catch via ElementActions ======

    /**
     * Fills username field using ElementActions.type with internal try-catch + retry.
     */
    public void enterUsername(String username) {
        actions.type(usernameInput, username);
    }

    /**
     * Fills password field using ElementActions.type with internal try-catch + retry.
     */
    public void enterPassword(String password) {
        actions.type(passwordInput, password);
    }

    /**
     * Clicks on login button using ElementActions.click with internal try-catch + retry.
     * If click fails the first time, it will retry once inside ElementActions.
     */
    public void clickLoginButton() {
        actions.click(loginButton);
    }
}

