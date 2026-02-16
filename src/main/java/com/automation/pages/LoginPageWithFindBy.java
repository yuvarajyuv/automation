package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Example Page Object class using @FindBy annotations (PageFactory style).
 *
 * - This class uses the same sample xpaths as LoginPage, but declared with @FindBy.
 * - Each WebElement has simple getter and action methods (setters) so you can
 *   call them from your main script file.
 *
 * In your test/script you will typically:
 *   LoginPageWithFindBy login = new LoginPageWithFindBy(driver);
 *   login.setUsername("someUser");
 *   login.setPassword("somePass");
 *   login.clickLoginButton();
 */
public class LoginPageWithFindBy {

    private final WebDriver driver;

    // ====== All XPaths / locators using @FindBy ======
    // NOTE: Replace these sample xpaths with your real application xpaths later.

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login']")
    private WebElement loginButton;

    public LoginPageWithFindBy(WebDriver driver) {
        this.driver = driver;
        // Initialize all @FindBy WebElements
        PageFactory.initElements(driver, this);
    }

    // ====== Getter methods (if you want to use elements directly in tests) ======

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    // ====== Setter / action methods you will typically call from script file ======

    /**
     * Set username in the username input box.
     * Example usage in test:
     *   loginPageWithFindBy.setUsername(ConfigReader.getUsername());
     */
    public void setUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    /**
     * Set password in the password input box.
     */
    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /**
     * Click on login button.
     */
    public void clickLoginButton() {
        loginButton.click();
    }
}

