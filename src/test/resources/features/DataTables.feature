

Feature: Cucumber Data Tables implementation practices

  Scenario: List of fruits and vegetables I like
    Then user should see below list
      | orange     |
      | apple      |
      | kiwi       |
      | strawberry |
      | potato     |
      | asparagus  |
      | carrot     |
      | mango      |
      | watermelon |

    Scenario: List of pets I love
      Then I will share my favorites
        | BELLA   |
        | SIF     |
        | MEEKO   |
        | ATTICUS |
        | EDDIE   |
        | DIXIE   |

      Scenario: Officer reads data about driver
        Then officer is able to see any data he wants
          | name    | Jane         |
          | surname | Doe          |
          | age     | 29           |
          | address | somewhere    |
          | state   | CA           |
          | zipcode | 90210        |
          | phone   | 999-999-9999 |




  Scenario: User should be able to see all 12 months in months dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |