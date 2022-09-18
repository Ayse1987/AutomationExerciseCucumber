Feature: verification in checkout page

  Background:
    Given navigate to baseUrl
    And verify that home page is visible successfully

  Scenario: TC23 user can verify address in checkout page
    When click on Signup Login button
    And fill all details in Signup and create account
    Then verify ACCOUNT CREATED! and click Continue button
    Then verify that Logged in as username is visible
    And add products to cart
    And click Cart button and verify that products are visible in cart
    Then verify that cart page is displayed
    And click Proceed To Checkout
    Then verify that the delivery address is same address filled at the time registration of account
    Then verify that the billing address is same address filled at the time registration of account
    Then verify Delete Account button is visible


  Scenario: TC24 user can download invoice after purchase
    When add products to cart
    And click Cart button and verify that products are visible in cart
    And click Proceed To Checkout
    And click Register Login button
    And fill all details in Signup and create account
    And verify ACCOUNT CREATED! and click Continue button
    Then verify that Logged in as username is visible
    And click Cart button
    And click Proceed To Checkout
    Then verify Address Details and Review Your Order
    And enter description in comment text area and click Place Order
    And enter payment details: Name on Card, Card Number, CVC, Expiration date
    And click Pay and Confirm Order button
    Then verify success message Your order has been placed successfully!
    And click Download Invoice button and verify invoice is downloaded successfully.
    Then click Continue button in checkout
    Then verify Delete Account button is visible

  @EndToEnd
  Scenario: E2E user can download invoice after purchase
    When click on Signup Login button
    And fill email, password and click Login button
    And verify that Logged in as username is visible
    When add products to cart
    And click Cart button and verify that products are visible in cart
    And click Proceed To Checkout
    Then verify Address Details and Review Your Order
    And enter description in comment text area and click Place Order
    And enter payment details: Name on Card, Card Number, CVC, Expiration date
    And click Pay and Confirm Order button
    Then verify success message Your order has been placed successfully!
    And click Download Invoice button and verify invoice is downloaded successfully.

