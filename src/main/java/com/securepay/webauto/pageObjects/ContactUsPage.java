package com.securepay.webauto.pageObjects;

import com.github.javafaker.Faker;
import com.securepay.webauto.data.ContactUsForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ContactUsPage extends BasePage {
    By firstName = By.name("first-name");
    By lastName = By.name("last-name");
    By email = By.name("email-address");
    By phone = By.name("phone-number");
    By websiteURL = By.name("website-url");
    By company = By.name("business-name");
    By reasonForEnquiry = By.name("reason-for-enquiry");

    private String firstNameText;
    private String lastNameText;
    private String phoneNumberText;
    private String emailText;
    private String websiteURLText;
    private String companyText;

    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    public void getFakeData(){
        ContactUsForm contactUsForm = new ContactUsForm(new Faker());
        firstNameText = contactUsForm.getFirstName();
        lastNameText = contactUsForm.getLastName();
        emailText = contactUsForm.getEmail();
        websiteURLText = contactUsForm.getWebsite();
        companyText = contactUsForm.getCompany();
        phoneNumberText = contactUsForm.getPhoneNumber();
    }

    public void fillContactUsForm(){
        typeText(firstName, firstNameText);
        typeText(lastName, lastNameText);
        typeText(email, emailText);
        typeText(phone, phoneNumberText);
        typeText(websiteURL, websiteURLText);
        typeText(company, companyText);
        selectReasonForEnquiry();
    }

    private void selectReasonForEnquiry(){
        Select select = new Select(findElement(reasonForEnquiry));
        List<WebElement> options = select.getOptions();
        int randomIndex = new Random().nextInt(options.size() - 1);
        select.selectByIndex(randomIndex + 1);
    }
}