Feature: User Feature
  Scenario: User should be able to login
    Given User is at the login page
    When User fill the email and password and login
    Then welcome message should be displayed