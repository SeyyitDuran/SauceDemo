Feature: Login and E2E Test

  @wip
  Scenario:E2E
    Given The user is on the login page
    When The user enters "standard_user" and "secret_sauce"
    Then The user should be able to login and see "Products" header
    And The user able to sort the by "Price (high to low)"
    And The user clicks first as "7.99" and second as "9.99" products
    And The user opens the basket
    And  The user clicks checkout
    And  The user enters details "Hi" "Sauce" "Demo" and finish the purchase
    Then The user verify that "Total: $19.42"
    And  The user clicks finish button
    Then The user able to see confirmation message as "Thank you for your order!"

