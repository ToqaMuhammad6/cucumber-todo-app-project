Feature: Todo Features
  Scenario: Should be able to add a todo
    Given User is at the todos page
    When User add a new todo
    Then Todo should be added correctly