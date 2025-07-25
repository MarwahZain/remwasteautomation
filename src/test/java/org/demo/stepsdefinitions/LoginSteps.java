package org.demo.stepsdefinitions;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.demo.pages.LoginPage;
import org.demo.utils.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class LoginSteps extends BaseStep{

    private LoginPage loginPage;
    private ExtentTest logger;

    @Given("the user opens the application")
    public void openLoginPage() {
        loginPage = new LoginPage(driver, config);
        logger = ExtentReportManager.getTest();

        loginPage.open();
        assertTrue(loginPage.isLoginPageDisplayed(), "Login page not visible");
        logger.info("User opened the application successfully.");
    }

    @When("the user logs in with valid credentials")
    public void loginWithValidCredentials() {
        loginPage.enterEmail(config.getValidUserName());
        loginPage.enterPassword(config.getValidPassword());
        loginPage.clickLogin();

        logger.info("User attempted login with valid credentials.");
    }

    @When("the user logs in with invalid credentials")
    public void loginWithInvalidCredentials() {
        loginPage.enterEmail(config.getInValidUserName());
        loginPage.enterPassword(config.getInValidPassword());
        loginPage.clickLogin();

        logger.info("User attempted login with invalid credentials.");
    }

    @Then("the dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        WebElement dashboard = driver.findElement(By.xpath("//*[contains(text(),'Dashboard')]"));
        assertTrue(dashboard.isDisplayed());
        logger.pass("Dashboard is visible.");
    }

    @Then("a welcome message should be visible")
    public void welcomeMessageShouldBeVisible() {
        WebElement welcome = driver.findElement(By.xpath("//*[contains(text(),'Welcome')]"));
        assertTrue(welcome.isDisplayed());
        logger.pass("Welcome message is displayed.");
    }

    @Then("an error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        WebElement error = driver.findElement(By.className("alert-danger"));
        assertTrue(error.getText().contains(expectedMessage));
        logger.fail("Error message shown: " + error.getText());
    }

}
