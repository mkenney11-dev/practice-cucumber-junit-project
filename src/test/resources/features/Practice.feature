
  Feature: Cydeo forgot password page functionality
  Agile story: As a user, when I am on the Cydeo forgot password page
    I should be able to enter my email and retrieve my password

    Scenario: Forgot password page title verification
      When user is on the forgot password page
     # Then user should see the title is Forgot Password


    Scenario: Retrieve Password button functionality
      When user has entered their email into the blank field
      Then user clicks the Retrieve Password button
      Then user should see new title Your e-mail's been sent!
