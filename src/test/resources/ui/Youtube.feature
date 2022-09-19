@youtubeTest
Feature: Simple test

  Scenario: Search and play music in youtube
    Given user goes to youtube website
    And user searches "best part daniel caesar" in the youtube search
    And user clicks and plays "Daniel Caesar & H.E.R. - Best Part, a Visual" on the search result
    Then user validates that video is playing
