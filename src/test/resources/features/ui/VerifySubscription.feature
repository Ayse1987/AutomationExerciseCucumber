Feature: Verify subscription

  Background:
    Given navigate to baseUrl
    And verify that home page is visible successfully

    Scenario: user can verify subscription in home page
    And scroll down to footer
    Then verify text SUBSCRIPTION
    When enter email address in input and click arrow button
    Then verify success message You have been successfully subscribed! is visible

      Scenario: user can verify subscription in cart
      When click Cart button
      And scroll down to footer
      Then verify text SUBSCRIPTION
      And enter email address in input and click arrow button
      Then verify success message You have been successfully subscribed! is visible