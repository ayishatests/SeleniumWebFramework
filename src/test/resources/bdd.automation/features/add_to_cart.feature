Feature: Add to cart

  @Regression
  Scenario Outline: Add one quantity from Store

  This scenario is written to add one product to cart and view that product into cart.
  So here, we add  <Blue Shoes>  and <Anchor Bracelet> product to cart.

    Given I'm on the Store Page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name |
      | Blue Shoes   |
      | Anchor Bracelet |


  @failTest
  Scenario: Add product from Store that does not exist

  This scenario fails because it was written to capture the screenshot on failure and attach to Extent Report.
  It fails in the second step because the Invalid Product does not exist on the store page, so the scenario fails to add it to cart

    Given I'm on the Store Page
    When I add a "Invalid Product" to the cart
    Then I should see 1 "Invalid Product" in the cart