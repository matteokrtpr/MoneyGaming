Feature: Six Characters Password
  Scenario Outline: Creating a password
    Given Navigate to create a password page
    When  User enter the "<Password>" with different Combinations
    Then Check the password that is "<ValidMessage>"

    Examples:
    |Passsword|   ValidMessage|
    |Matteo4  |