@Cart
Feature: Cart functions

  Background:
    Given navigate to baseUrl
    And verify that home page is visible successfully

  Scenario: TC17 Remove products from Cart
    When add products to cart
    When click Cart button
    Then verify that cart page is displayed
    When click X button corresponding to particular product
    Then verify that product is removed from the cart

  Scenario: TC18 view Category products
    Then verify that categories are visible on left side bar
    When click on Women category
    When click on any category link under Women category, for example: Dress
    Then verify that category page is displayed and confirm text WOMEN - TOPS PRODUCTS
    And On left side bar, click on any sub-category link of Men category
    Then verify that user is navigated to that category page

  Scenario: TC22 user can add to cart from recommended items
    When scroll down to footer
    Then verify RECOMMENDED ITEMS are visible
    And click on Add To Cart on Recommended product
    When click View Cart button
    Then verify that product is displayed in cart page