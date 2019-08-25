package com.securepay.webauto.managers;

import com.securepay.webauto.pageObjects.ContactUsPage;
import com.securepay.webauto.pageObjects.SearchHomePage;
import com.securepay.webauto.pageObjects.SearchResultPage;
import com.securepay.webauto.pageObjects.HomePage;

public class PageObjectManager {
    private SearchHomePage searchHomePage;
    private SearchResultPage searchResultPage;
    private HomePage homePage;
    private ContactUsPage contactUsPage;

    public SearchHomePage getSearchHomePage() {
        return searchHomePage;
    }

    public void setSearchHomePage(SearchHomePage searchHomePage) {
        this.searchHomePage = searchHomePage;
    }

    public SearchResultPage getSearchResultPage() {
        return searchResultPage;
    }

    public void setSearchResultPage(SearchResultPage searchResultPage) {
        this.searchResultPage = searchResultPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage securePayHomePage) {
        this.homePage = securePayHomePage;
    }

    public ContactUsPage getContactUsPage() {
        return contactUsPage;
    }

    public void setContactUsPage(ContactUsPage contactUsPage) {
        this.contactUsPage = contactUsPage;
    }
}