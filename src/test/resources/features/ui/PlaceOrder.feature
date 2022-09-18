@PlaceOrder
Feature: place order

  Background:
    Given navigate to baseUrl
    And verify that home page is visible successfully

  Scenario: user can place order by registering while checkout
    When add products to cart
    When click Cart button
    Then verify that cart page is displayed
    When click Proceed To Checkout
    And click Register Login button
    And fill all details in Signup and create account
    Then verify ACCOUNT CREATED! and click Continue button
    Then verify that Logged in as username is visible
    When click Cart button
    And click Proceed To Checkout button
    Then verify Address Details and Review Your Order
    And enter description in comment text area and click Place Order
    And enter payment details: Name on Card, Card Number, CVC, Expiration date
    When click Pay and Confirm Order button
    Then verify success message Your order has been placed successfully!
    Then verify Delete Account button is visible

  Scenario: TC15 user can place order registering before checkeout
    When click on Signup Login button
    And fill all details in Signup and create account
    Then verify ACCOUNT CREATED! and click Continue button
    Then verify that Logged in as username is visible
    And add products to cart
    When click Cart button
    Then verify that cart page is displayed
    When click Proceed To Checkout
    Then verify Address Details and Review Your Order
    And enter description in comment text area and click Place Order
    And enter payment details: Name on Card, Card Number, CVC, Expiration date
    When click Pay and Confirm Order button
    Then verify success message Your order has been placed successfully!
    When click Delete Account button
    Then verify Delete Account button is visible

  Scenario: TC16 user can place order logging in before checkout
    When click on Signup Login button
    And fill email, password and click Login button
    Then verify that Logged in as username is visible
    And add products to cart
    When click Cart button
    Then verify that cart page is displayed
    When click Proceed To Checkout
    Then verify Address Details and Review Your Order
    When enter description in comment text area and click Place Order
    And enter payment details: Name on Card, Card Number, CVC, Expiration date
    When click Pay and Confirm Order button
    Then verify success message Your order has been placed successfully!
    Then verify Delete Account button is visible
