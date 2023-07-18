
Feature: Verify and search products

  Background:
    Given navigate to baseUrl
    And verify that home page is visible successfully

  Scenario: Verify All products and product detail page
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    Then the products list is visible
    When click on View Product of first product
    Then user is landed to product detail page
    Then verify that detail detail is visible: product name, category, price, availability, condition, brand

  Scenario: TC12 user can add products in cart
    When click Products button
    And hover over first product and click Add to cart
    When click Continue Shopping button
    And hover over second product and click Add to cart
    When click View Cart button
    Then verify both products are added to Cart
    Then verify their prices, quantity and total price

  Scenario: TC13 user can verify product quantity in cart
    When Click View Product for any product on home page
    Then verify product detail is opened
    And increase quantity to 4
    When click Add to cart button
    When click View Cart button
    Then Verify that product is displayed in cart page with exact quantity

  @Product
  Scenario: TC20 search product and verify in the cart
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    And enter product name in search input and click search button
    Then verify SEARCHED PRODUCTS is visible
    Then verify all the products related to search are visible
    And add those products to cart
    And click Cart button and verify that products are visible in cart

  Scenario: TC21 user can see the products in cart after login
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    And click on View Product of first product
    Then verify Write Your Review is visible
    And enter name "John" email "john@gmail.com" and review "Great item!"
    When click Submit button for review
    Then verify success message Thank you for your review.