package com.securepay.webauto.pageObjects;

import com.securepay.webauto.config.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    By securePayLink = By.partialLinkText(ConfigFileReader.getInstance().getSecurePayURL());

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickSecurePayResult(){
        click(securePayLink);
        return new HomePage(driver);
    }
}
