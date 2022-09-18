Feature: Simple test

  @input
  Scenario: This scenario is just to click Edit Button
    Given user goes to letCode website
    And user clicks input button

  @sampleTest2
    Scenario: This scenario is just to enter full name in Edit Page
      Given user goes to letCode edit page
      And user enters full name "John Doe"
      And user enters "how are you?" on append a text
      And user confirms that the field is disabled

    @sampleTest3
    Scenario: This scenario is to select dropdown
      Given user goes to letCode dropdown page
      And user selects "blockchain" programming language

  @sampleTest4
  Scenario: This scenario is to search and find university name
    Given user goes to letCode advanced table page
    And user searches "Khan" in the search bar
    And user validates that "Aga Khan University" result is displayed


