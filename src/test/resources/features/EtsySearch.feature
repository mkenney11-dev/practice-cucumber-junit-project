

Feature: Etsy search functionality
  Agile story: User should be able to type any keyword and see relevant information

  Scenario: Etsy home page title verification
    Given user is on the Etsy home page
    Then user should see title is as expected
    #expected title is Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    Given user is on the Etsy home page
    When user types "Wooden Spoon" in the search box
    And user clicks Etsy search button
    Then user sees "Wooden spoon - Etsy" in the title