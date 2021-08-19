 Feature: Login Functionality

   Scenario: Login with credential
     Given navigate to MoneyGaming login page
     When click the first join now on login page
     And select a title
     When enter your first name and last name
     And check the the tickbox
     And submit the form by clicking JOINNOW button
     Then validate the message with text 