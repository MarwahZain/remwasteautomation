package org.demo.stepsdefinitions;

import org.demo.entities.TestConfig;
import org.demo.util.DriverFactory;
import org.openqa.selenium.WebDriver;


public class BaseStep {

    protected WebDriver driver;
    protected TestConfig config;

    public BaseStep() {
        this.driver = DriverFactory.getDriver();
        this.config = new TestConfig();
    }
}
