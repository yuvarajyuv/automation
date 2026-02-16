package com.automation.core;

import com.automation.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Base test class.
 *
 * - Holds a single WebDriver instance shared by tests (protected field).
 * - Uses WebDriverManager to set up browser drivers.
 * - Reads base URL from config.properties via ConfigReader.
 * - Contains TestNG lifecycle methods (before/after suite/class/test).
 *
 * You will extend this class in your main script/test classes.
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        // TODO: Add code here if you want to run something once before entire suite
        // Example: starting reporting, logging setup, etc.
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        // TODO: Add code here if you want to run something once after entire suite
        // Example: flushing reports, cleanup actions, etc.
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        // TODO: Add class-level setup if needed.
        // NOTE: Do NOT create WebDriver here, it is handled in @BeforeTest below.
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        // TODO: Add class-level cleanup if needed.
    }

    /**
     * BeforeTest: this is where we open the browser using WebDriverManager.
     *
     * The "browser" value is passed from testng.xml:
     *   <parameter name="browser" value="chrome"/>
     *
     * If you change the value to "firefox" or "edge" in the suite file,
     * the corresponding browser will open.
     */
    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();

        // Navigate to URL from properties file
        // You will put the actual URL in config.properties under key "base.url"
        String baseUrl = ConfigReader.getBaseUrl();
        if (baseUrl != null && !baseUrl.isEmpty()) {
            driver.get(baseUrl);
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

