@googleTest
Feature: Simple test

  Scenario: Input in Google Search bar using ini file
    Given user goes to google website
    And user "She" inputs "firstName" in the searchbar

  Scenario: Input in Google Search bar using yml file
    Given user goes to google website
    And user inputs "personal_info_data" in the searchbar