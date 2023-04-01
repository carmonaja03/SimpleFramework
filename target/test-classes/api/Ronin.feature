@alltestcase
Feature: Get details

  @ronin
  Scenario: Get Token stake by ronin addess
    Given user gets staked address from "ronin:c45ba6ba16cd040fce0cace61a2f2f9e51695360"
    Then user displays total AXS staked