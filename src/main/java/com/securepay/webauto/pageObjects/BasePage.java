package com.securepay.webauto.pageObjects;

import com.securepay.webauto.config.ConfigFileReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, ConfigFileReader.getInstance().getExplicitlyWait());
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void clear(By locator){
        findElement(locator).clear();
    }

    public void typeText(By locator, String inputText) {
        findElement(locator).sendKeys(inputText);
    }

    public void sendKeys(By locator, Keys key){
        findElement(locator).sendKeys(key);
    }

    public void click(By locator){
        findElement(locator).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}