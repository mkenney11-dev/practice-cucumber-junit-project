

Feature: Web Table app login functionality
  Agile story: user should be able to login with correct credentials


  Scenario: Positive login scenario
    Given user is on the Web Table app login page
    Then user enters correct username
    And user enters correct password
    And user clicks to login button
    Then user should see orders word in the URL


  Scenario: Positive login scenario
    Given user is on the Web Table app login page
    Then user enters "Test" username and "Tester" password
    And user clicks to login button
    Then user should see orders word in the URL

  Scenario: Positive login scenario
    Given user is on the Web Table app login page
    When  user enters below correct credentials
      | username | Test   |
      | password | Tester |
    And user clicks to login button
    Then user should see orders word in the URL