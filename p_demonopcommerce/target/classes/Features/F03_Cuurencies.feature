@smoke
  Feature: user could select different currencies

    Scenario: user could switch to other currency different than dollar
      When user change currency selection to euro
      Then verify that euro symbol is visible on home page