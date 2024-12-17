@regression
Feature: Register Functionality

  @smoke
  Scenario: User should navigate to the register page successfully
    Given I am on the home page
    When I click on the Register link
    Then I should see the text Register

#  @smoke
#  Scenario: Verify that First Name, Last Name, Email, Password, and Confirm Password fields are mandatory
#    Given I am on the home page
#    When I click on the Register link
#    And I click on the Register button
#    Then I should see the error message "First name is required."
#    And I should see the error message "Last name is required."
#    And I should see the error message "Email is required."
#    And I should see the error message "Password is required."
#    And I should see the error message "Confirm password is required."

  @sanity
  Scenario Outline: Verify that First Name, Last Name, Email, Password, and Confirm Password fields are mandatory
    Given I am on the home page
    When I click on the Register link
    And I click on the Register button
    Then I should see the error message "<errorMessage>"
    And I should see the error message "<errorMessage>"
    And I should see the error message "<errorMessage>"
    And I should see the error message "<errorMessage>"
    And I should see the error message "<errorMessage>"
    Examples:
      | errorMessage                  |
      | First name is required.       |
      | Last name is required.        |
      | Email is required.            |
      | Password is required.         |
      | Confirm password is required. |


  @sanity
  Scenario: Verify that user should create an account successfully
    Given I am on the home page
    When I click on the Register link
    And I select gender Female
    And I enter "First Name" in the first name field
    And I enter "Last Name" in the last name field
    And I enter "prashant223311@gmail.com" in the email field
    And I enter "Pk123456" in the password field
    And I enter "password123" in the confirm password field
    And I click on the Register button
    Then I should see the message "Your registration completed"
