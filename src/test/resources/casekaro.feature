Feature: CaseKaro - Add Hard/Soft/Glass items for mobile case and validate cart

  @smoke
  Scenario: Search, verify a brand and add different types, validate cart and print prices
    Given I open CaseKaro website
    When I navigate to Mobile covers
    And I search for brand "iPhone"
    Then I should not see other brands after iPhone search
    When I search for model "iPhone 16 Pro"
    And I select model from results "iPhone 16 Pro"
    And I open first product using Choose options
    And I add all materials to cart
    Then I open cart and validate three materials
    And I print cart details to console
