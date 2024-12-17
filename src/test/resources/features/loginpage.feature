@regression
Feature: Login Functionality
  In Order to perform successful login
  As a User
  I have to enter correct username and password

  @smoke
  Scenario: User should navigate to the login page successfully
    Given I am on the home page
    When I click on the login link
    Then I should see the message "Welcome, Please Sign In!"

  @sanity
  Scenario Outline: Verify the error message with invalid credentials
    Given I am on the home page
    When I click on the login link
    And I enter "<email>" in the email field
    And I enter "<password>" in the password field
    And I click on the login button
    Then I should see an error message "<errorMessage>"
    Examples:
      | email                 | password | errorMessage                                                                                |
      | prashant135@gmail.com | Pk123    | Login was unsuccessful. Please correct the errors and try again.\nNo customer account found |
      | prashant13@gmail.com  | Pk123456 | Login was unsuccessful. Please correct the errors and try again.\nNo customer account found |
      | prashant15@gmail.com  | Pk123456 | Login was unsuccessful. Please correct the errors and try again.\nNo customer account found |



  Scenario: Verify that the user should log in successfully with valid credentials
    Given I am on the home page
    When I click on the login link
    And I enter "prashant135@gmail.com" in the email field
    And I enter "Pk123456" in the password field
    And I click on the login button
    Then I should see the log out link displayed


  Scenario: Verify that the user should log out successfully
    Given I am on the home page
    When I click on the login link
    And I enter "prashant135@gmail.com" in the email field
    And I enter "Pk123456" in the password field
    And I click on the login button
    And I click on the log out link
    Then I should see the login link displayed
