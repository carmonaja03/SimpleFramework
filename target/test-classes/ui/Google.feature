
Feature: Simple test

  Scenario: Input in Google Search bar using ini file
    Given user goes to google website
    And user "Search" inputs "searchItem1" in the searchbar
  @googleTest
  Scenario: Input in Google Search bar using yml file
    Given user goes to google website
    And user inputs first name "personal_info" in the searchbar