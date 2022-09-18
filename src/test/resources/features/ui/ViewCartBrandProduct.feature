@Brand
Feature: View cart brand products

  Background:
    Given navigate to baseUrl
    And verify that home page is visible successfully

    Scenario: TC19 user can view brand products in cart
    When click on Products button
    Then verify that Brands are visible on left side bar
    When click on any brand name
    Then verify that user is navigated to brand page and brand products are displayed
    And on left side bar, click on any other brand link
    Then verify that user is navigated to that brand page and can see products
