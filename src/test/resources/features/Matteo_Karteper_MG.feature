Feature: Create a valid Password
  Scenario Outline: Creating a password
    Given Navigate to create a password page
    When  User enter the "<Password>" with different Combinations
    Then Check the password that is "<ValidMessage>"

    Examples:
    |Password    |ValidMessage |
    |Matt        |Password should be at least 6 characters |
    |Matteo      |Password should be at least 1 number and 1 special character|
    |Matteo1!    |Please confirm the password|