package org.demo.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import org.demo.util.DriverFactory;
import org.demo.utils.ExtentReportManager;
import org.demo.utils.ReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;
    private ExtentReports extent;

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        extent = ReportManager.getInstance();
        ExtentTest test = extent.createTest(scenario.getName());
        ExtentReportManager.setTest(test);

        test.info("Scenario started: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        ExtentTest test = ExtentReportManager.getTest();

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            test.fail("Scenario failed: " + scenario.getName())
                    .addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64), "Screenshot on Failure");
        } else {
            test.pass("Scenario passed: " + scenario.getName());
        }

        DriverFactory.quitDriver();
        ExtentReportManager.removeTest();
    }

    @AfterAll
    public static void afterAll() {
        ReportManager.flushReports();
    }
}
