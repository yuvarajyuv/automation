package com.automation.tests;

import com.automation.core.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.LoginPageWithFindBy;
import com.automation.utils.ConfigReader;
import com.automation.utils.TestDataUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Main script file (sample test class).
 *
 * - Extends BaseTest so it can use the WebDriver instance.
 * - Uses LoginPage (locators + actions) to perform UI interactions.
 * - Uses ConfigReader to fetch username/password/url from properties.
 * - Uses TestDataUtils when random data is required.
 *
 * TODO (you will implement later inside test method):
 *   1) Use username and password from ConfigReader.
 *   2) Call LoginPage methods to perform login.
 *   3) Add assertions to validate successful login / error message.
 */
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private LoginPageWithFindBy loginPageWithFindBy;

    @BeforeClass(alwaysRun = true)
    public void setUpPageObjects() {
        // Initialize page object using driver instance from BaseTest
        loginPage = new LoginPage(driver);
        // Initialize alternative page object that uses @FindBy (PageFactory style)
        loginPageWithFindBy = new LoginPageWithFindBy(driver);
    }

    @Test(description = "Sample login test using data from config.properties")
    public void sampleLoginTest() {
        // ===== Example of how you will use this test =====
        //
        // 1) Get username, password, and base URL from config.properties:
        String username = ConfigReader.getUsername();
        String password = ConfigReader.getPassword();
        String baseUrl = ConfigReader.getBaseUrl();
        //
        // NOTE: BaseTest already navigates to baseUrl in @BeforeTest.
        // If you want to navigate explicitly here, you can do:
        // driver.get(baseUrl);
        //
        // 2a) Use LoginPage methods (By + ElementActions with retry) to interact with elements:
        // loginPage.enterUsername(username);
        // loginPage.enterPassword(password);
        // loginPage.clickLoginButton();
        //
        // 2b) OR use LoginPageWithFindBy methods (@FindBy + getters/setters) to interact with elements:
        // loginPageWithFindBy.setUsername(username);
        // loginPageWithFindBy.setPassword(password);
        // loginPageWithFindBy.clickLoginButton();
        //
        // If you want to use getters for direct WebElement access:
        // loginPageWithFindBy.getUsernameInput().sendKeys(username);
        // loginPageWithFindBy.getPasswordInput().sendKeys(password);
        // loginPageWithFindBy.getLoginButton().click();
        //
        // 3) Use TestDataUtils for any random/unique fields if required:
        // String randomRef = TestDataUtils.generateRandomString(8);
        // driver.findElement(By.id("reference")).sendKeys(randomRef);
        //
        // 4) Add assertions using TestNG Assert class:
        // Assert.assertTrue(condition, "Description of what you are validating");
        //
        // For now, this method is a template. You will uncomment and complete
        // the steps above according to your application under test.
    }
}

