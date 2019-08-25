Feature: Secure Pay Contact Us Validations

  Scenario: Verify contact us page loaded
    Given Open "https://www.google.com.au"
    When Searches for "SecurePay"
    And Clicks through to the SecurePay website
    And Navigates to the contact us page
    Then Verifies that the contact us page is loaded

  Scenario: Fill in contact us form with random data
    Given Generates random data using an open-source library
    Then Uses the generated data to fill in the contact us form