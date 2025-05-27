@smoke
Feature: user could create new accounts

  Scenario: user creates new valid account
    Given user opens register page
    When user selects gender type
    And user enters first name "automation" and last name "tester"
    And user selects date of birth
    And user enters the email "test@example.com"
    And user fills password fields "P@sswOrd" "P@sswOrd"
    And user clicks on register button
    Then success message is displayed
