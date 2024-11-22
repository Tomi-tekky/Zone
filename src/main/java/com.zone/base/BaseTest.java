package com.zone.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zone.utils.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {

    protected static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;
    protected Properties config;

    public static WebDriver getDriver() {
        return driver.get();
    }


    @BeforeSuite
    public void beforeSuite() {

        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp() {

        // Set the path for the ChromeDriver
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");  // Run Chrome in headless mode
        //chromeOptions.addArguments("--no-sandbox");  // Required in some environments
        //chromeOptions.addArguments("--disable-dev-shm-usage");  // Overcome limited resource problems
        //chromeOptions.addArguments("--disable-gpu");  // Optional, speeds up headless execution in some cases

        WebDriverManager.chromedriver().setup();

        driver.set(new ChromeDriver(chromeOptions));

        // Load configuration properties
        config = new Properties();
        // Add code to load properties from config file

        // Maximize browser and set timeouts
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, "Reason: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }

        logger.info("Tearing down the test environment.");
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }

        logger.info("Test environment teardown completed.");
    }
    @AfterSuite
    public void afterSuite () {
        extent.flush();
    }
}

