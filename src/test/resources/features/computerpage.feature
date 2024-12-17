@regression
Feature: Computer Page Navigation

  @smoke
  Scenario: User should navigate to the computer page successfully
    Given I am on the home page
    When I click on the COMPUTER tab
    Then I should see the text Computers

  @sanity
  Scenario: User should navigate to desktops page successfully
    Given I am on the home page
    When I click on the COMPUTER tab
    And I click on the Desktops link
    Then I should see the text "Desktops"

  Scenario Outline: User should build their own computer and add it to the cart successfully
    Given I am on the home page
    When I click on the COMPUTER tab
    And I click on the Desktops link
    And I click on the product name "Build your own computer"
    And I select processor "<processor>"
    And I select RAM "<ram>"
    And I select HDD "<hdd>"
    And I select OS "<os>"
    And I select software "<software>"
    And I click on the Add to Cart button
    Then I should see the message "The product has been added to your shopping cart"

    Examples:
      | processor                             | ram  | hdd    | os                  | software                   |
      | 2.2 GHz Intel Pentium Dual-Core E2200 | 2 GB | 320 GB | Windows 7 [+50.00]  | Microsoft Office [+$50.00] |
      | 2.5 GHz Intel Pentium Dual-Core E2200 | 4 GB | 400 GB | Windows 10 [+60.00] | Acrobat Reader [+$10.00]   |
      | 2.5 GHz Intel Pentium Dual-Core E2200 | 8 GB | 320 GB | Ubuntu              | Total Commander [+$5.00]   |
