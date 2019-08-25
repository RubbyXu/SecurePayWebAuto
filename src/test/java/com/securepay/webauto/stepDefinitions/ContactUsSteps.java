package com.securepay.webauto.stepDefinitions;

import com.securepay.webauto.config.ConfigFileReader;
import com.securepay.webauto.cucumber.TestContext;
import com.securepay.webauto.pageObjects.ContactUsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class ContactUsSteps {
    private TestContext testContext;
    private static ContactUsPage contactUsPage;

    public ContactUsSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @Then("^Verifies that the contact us page is loaded$")
    public void verifiesThatTheContactUsPageIsLoaded() {
        contactUsPage = testContext.getPageObjectManager().getContactUsPage();
        String contactUsPageTitle = contactUsPage.getPageTitle();
        Assert.assertTrue(contactUsPageTitle.startsWith(ConfigFileReader.getInstance().getSecurePayContactUs()));
    }

    @Given("^Generates random data using an open-source library$")
    public void generatesRandomDataUsingAnOpenSourceLibrary() {
        contactUsPage.getFakeData();
    }

    @Then("^Uses the generated data to fill in the contact us form$")
    public void usesTheGeneratedDataToFillInTheContactUsForm() {
        contactUsPage.fillContactUsForm();
    }
}