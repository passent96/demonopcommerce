@smoke
Feature: user should be able to use hover command
  Scenario: user hover on one of main categories then click on sub-categories
    When user selects random one of the three main categories in Home page
    And user hover on selected category
    And user selects random one of the sub-categories
    Then user gets page subtitle text and compare it with the random sub-category


