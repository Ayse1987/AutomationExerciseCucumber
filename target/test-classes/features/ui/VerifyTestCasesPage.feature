Feature: Verify test case page

  Background:
    Given navigate to baseUrl
    And verify that home page is visible successfully

  Scenario: user should be able to navigate to test cases page successfully
    When click on Test Cases button
    Then verify user is navigated to test cases page successfully