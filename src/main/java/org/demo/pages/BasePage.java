package org.demo.pages;

import org.demo.entities.TestConfig;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected TestConfig config;

    public BasePage(WebDriver driver, TestConfig config) {
        this.driver = driver;
        this.config = config;
    }

    public void navigateToBaseUrl() {
        driver.get(config.getBaseUrl());
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
