@Registration
Feature: Register user, login,log out

  Background:
    Given navigate to baseUrl
    And verify that home page is visible successfully
    When click on Signup Login button

    @Smoke
  Scenario: user should be able to register with valid credentials
    Then verify New User Signup! is visible
    And enter name and email address
    When click Signup button
    Then verify that ENTER ACCOUNT INFORMATION is visible
    And fill details: Title, Name, Email, Password, Date of birth
    And select checkbox Sign up for our newsletter!
    And select checkbox Receive special offers from our partners!
    And fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    When click Create Account button
    Then verify that ACCOUNT CREATED! is visible
    When click Continue button
    Then verify that Logged in as username is visible
    Then verify Delete Account button is visible
    And close driver

      @Smoke
  Scenario: given valid credentials user should be able to login successfully
    Then verify Login to your account is visible
    And enter correct email address and password
    When click login button
    Then verify that Logged in as username is visible
    Then verify Delete Account button is visible
    And close driver

        @Smoke
  Scenario: given invalid credentials user should not be able to login
    Then verify Login to your account is visible
    And enter incorrect email address and password
    When click login button
    Then verify error Your email or password is incorrect! is visible
    And close driver


  Scenario: user should be able to log out succesfully
    Then verify Login to your account is visible
    And enter correct email address and password
    When click login button
    Then verify that Logged in as username is visible
    When click Logout button
    Then verify that user is navigated to login page
    And close driver

  Scenario: Register user with existing email
    Then verify New User Signup! is visible
    And enter name and already registered email address
    When click Signup button
    Then verify error Email Address already exist! is visible
    And close driver
