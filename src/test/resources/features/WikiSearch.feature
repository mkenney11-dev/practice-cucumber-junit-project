@wiki
Feature:
  Agile story: As a user, when I am on the Wikipedia home page
  I should be able to search anything and see relevant results


  Scenario: Search result title verification
    Given user is on the Wikipedia home page
    When user enters "Elvis Presley" in the wiki search box
    Then user clicks wiki search button
    Then user should see "Elvis Presley" in the title

  Scenario: Wikipedia Search Functionality Header Verification
    Given user is on the Wikipedia home page
    When user enters "Elvis Presley" in the wiki search box
    Then user clicks wiki search button
    Then user should see "Elvis Presley" in the main header

  Scenario: Wikipedia Search Functionality Image Header Verification
    Given user is on the Wikipedia home page
    When user enters "Elvis Presley" in the wiki search box
    Then user clicks wiki search button
    Then user should see "Elvis Presley" in the image header

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality with Scenario Outline
    Given user is on the Wikipedia home page
    When user enters "<searchValue>" in the wiki search box
    Then user clicks wiki search button
    Then user should see "<expectedTitle>" in the title
    Then user should see "<expectedMainHeader>" in the main header
    Then user should see "<expectedImageHeader>" in the image header

    Examples: search values we are going to use in the scenarios outline

      | searchValue     | expectedTitle    | expectedMainHeader | expectedImageHeader |
      | Elvis Presley   | Elvis Presley   | Elvis Presley       | Elvis Presley       |
      | Albert Einstein | Albert Einstein | Albert Einstein     | Albert Einstein     |
      | John F Kennedy  | John F Kennedy  | John F Kennedy      | John F Kennedy      |