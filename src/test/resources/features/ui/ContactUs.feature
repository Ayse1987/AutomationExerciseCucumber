Feature: Contact us form

  Background:
    Given navigate to baseUrl
    And verify that home page is visible successfully

  Scenario: user should be able to fill contact us form and submit successfully
    When click on Contact Us button
    Then verify GET IN TOUCH is visible
    And enter name, email, subject and message
    And upload file
    When click Submit button
    When click OK button
    Then verify success message Success! Your details have been submitted successfully. is visible
    Then click Home button and verify that landed to home page successfully