package com.securepay.webauto.stepDefinitions;

import com.securepay.webauto.cucumber.TestContext;
import com.securepay.webauto.pageObjects.SearchHomePage;
import com.securepay.webauto.pageObjects.SearchResultPage;
import com.securepay.webauto.pageObjects.HomePage;
import com.securepay.webauto.runner.TestRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class SearchSteps extends TestRunner {
    private SearchResultPage searchResultPage;
    private TestContext testContext;

    public SearchSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @Given("^Open \"([^\"]*)\"$")
    public void open(String googleURL){
        driver.get(googleURL);
    }

    @When("^Searches for \"([^\"]*)\"$")
    public void searchesFor(String searchText){
        SearchHomePage searchHomePage = new SearchHomePage(driver);
        searchResultPage = searchHomePage.searchFor(searchText);
    }

    @And("^Clicks through to the SecurePay website$")
    public void clicksThroughToTheSecurePayWebsite() {
        HomePage homePage = searchResultPage.clickSecurePayResult();
        testContext.getPageObjectManager().setHomePage(homePage);
    }
}