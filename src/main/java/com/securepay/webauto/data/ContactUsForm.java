package com.securepay.webauto.data;

import com.github.javafaker.Faker;

public class ContactUsForm {
    private Faker faker;

    public ContactUsForm(Faker faker) {
        this.faker = faker;
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getWebsite() {
        return faker.internet().url();
    }

    public String getCompany() {
        return faker.company().name();
    }
}
