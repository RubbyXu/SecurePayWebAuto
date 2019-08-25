package com.securepay.webauto.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchHomePage extends BasePage {
    By searchField = By.name("q");

    public SearchHomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchFor(String searchText) {
        typeText(searchField, searchText);
        sendKeys(searchField, Keys.ENTER);
        return new SearchResultPage(driver);
    }
}