@tag
Feature: feature to test sending email

  @tag1
  Scenario: Sending email
    Given browser is open
    And User is on google search page
    When User enters a text in a search box
    And User waits 5 seconds
    And hits Enter
    Then User is navigated to search feature
    And User clicks on Gmail sign in
    Then User signs on 
    And User clicks on Dots
    Then User clicks on app
    And User clicks on Compose button
    Then User sends an email with subject "Test" and body "This is a test"
  	Then User closes the browser
    