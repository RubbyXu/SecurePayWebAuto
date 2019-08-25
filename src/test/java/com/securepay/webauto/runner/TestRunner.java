package com.securepay.webauto.runner;

import com.securepay.webauto.managers.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features="src/main/resources/features", glue="com.securepay.webauto/stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {
    protected static WebDriver driver;

    @BeforeSuite
    public void setUpSuite(){
        driver = new WebDriverManager().getDriver();
    }

    @AfterSuite
    public void tearDownSuite(){
        driver.quit();
    }
}
