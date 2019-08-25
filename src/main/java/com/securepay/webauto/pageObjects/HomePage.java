package com.securepay.webauto.pageObjects;

import com.securepay.webauto.config.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    By contactUs = By.partialLinkText(ConfigFileReader.getInstance().getSecurePayContactUs());

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage navigateToContactUs(){
        WebDriverWait wait = new WebDriverWait(driver, ConfigFileReader.getInstance().getExplicitlyWait());
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs));
        click(contactUs);
        wait.until(ExpectedConditions.titleContains(ConfigFileReader.getInstance().getSecurePayContactUs()));
        return new ContactUsPage(driver);
    }
}
