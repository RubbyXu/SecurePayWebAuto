package com.securepay.webauto.stepDefinitions;

import com.securepay.webauto.cucumber.TestContext;
import com.securepay.webauto.pageObjects.ContactUsPage;
import com.securepay.webauto.pageObjects.HomePage;
import cucumber.api.java.en.And;

public class HomeSteps {
    private TestContext testContext;

    public HomeSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @And("^Navigates to the contact us page$")
    public void navigatesToTheContactUsPage() {
        HomePage homePage = testContext.getPageObjectManager().getHomePage();
        ContactUsPage contactUsPage = homePage.navigateToContactUs();
        testContext.getPageObjectManager().setContactUsPage(contactUsPage);
    }
}