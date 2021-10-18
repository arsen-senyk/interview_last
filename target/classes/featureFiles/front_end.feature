Feature: need to add desc

  @selenium
  Scenario: Use sign in button
    Given the user is on shop's main page http://automationpractice.com/index.php
    When click a button for signing in
    Then a page for creating account opens
    And enters uses _email address_ to create a new account test@gmail.pl
    And click create account button
    Then a form to be filled in with user's data opens
    Given the user filled in all necessary data in the page for creating an account Pawel Plocki test test
    And submits the data with a button
    Then user is logged in to the account
    Given the account for the user is created
    And user is on shop's main page http://automationpractice.com/index.php
    When user logs in to created account
    Then My account page is displayed