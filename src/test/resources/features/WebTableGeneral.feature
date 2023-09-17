Feature: Some of the general functionality verifications

  Scenario: Dropdown options verification
    Given user is already logged in to the Web Table app
    When user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |


  Scenario: Payment options verification
    Given user is already logged in to the Web Table app
    When user is on the Order page
    Then user sees Visa as enabled payment option
    Then user sees MasterCard as enabled payment option
    Then user sees American Express as enabled payment option


  Scenario: Order placement scenario
    Given user is already logged in to the Web Table app
    When user is on the Order page
    And user enters quantity "2"
    Then user clicks to the calculate button
    And user enters customer name "Jane Doe"
    And user enters street "7th Street"
    And user enters city "New York"
    And user enters state "New York"
    And user selects payment option "American Express"
    And user enters credit card number "1111333344445555"
    And user enters expiration date "01/26"
    And user clicks to process order button
    Then user should see "Jane Doe" in the first row of the web table

@wip
  Scenario Outline: Order placement scenario
    Given user is already logged in to the Web Table app
    When user is on the Order page
    And user enters quantity "<quantity>"
    Then user clicks to the calculate button
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user selects payment option "<paymentType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiration date "<expDate>"
    And user clicks to process order button
    Then user should see "<expectedName>" in the first row of the web table

    Examples:

      | quantity | customerName | street | city | state | paymentType | cardNumber       | expDate | expectedName |
      | 2        | John Doe     | 7th st | NY   | N'Y   | Visa       | 8888777799990000 | 09/28   | John Doe     |
      | 2        | Mark Smith   | 7th st | NY   | N'Y   | Visa       | 8888777799990000 | 09/28   | Mark Smith   |
      | 2        | Jane Doe     | 7th st | NY   | N'Y   | Visa       | 8888777799990000 | 09/28   | Jane Doe     |
      | 2        | Jack Chris   | 7th st | NY   | N'Y   | Visa      | 8888777799990000 | 09/28   | Jack Chris   |