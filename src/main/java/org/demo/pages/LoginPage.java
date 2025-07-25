package org.demo.pages;

import org.demo.entities.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.tagName("button");

    public LoginPage(WebDriver driver, TestConfig config) {
        super(driver, config);
    }

    public void open() {
        navigateToBaseUrl();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

}