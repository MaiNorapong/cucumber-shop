Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given a product Bread with price 20.50 exists
    And a product Jam with price 80.00 exists
    And a product Pickle with price 40.00 exists

    And an inventory has 2 items of product Bread in stock
    And an inventory has 3 items of product Jam in stock
    And an inventory has 0 items of product Pickle in stock

Scenario: Buy one product
    When I buy Bread with quantity 2
    Then total should be 41.00

Scenario: Buy multiple products
    When I buy Bread with quantity 2
    And I buy Jam with quantity 1
    Then total should be 121.00

Scenario: Buy out of stock products
    When I try to buy Pickle with quantity 1 I can't

Scenario: Buy products more than stocked
    When I try to buy Jam with quantity 10 I can't


