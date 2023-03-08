Feature: User should be able to login valid credentials

  Background: user is on the login page
    Given user is on the login page of the web table app

  Scenario: Positive login scenario

    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains orders


  Scenario: Positive login scenario

    When user enters username "Test"  password "Tester" and login
    Then user should see url contains orders

      #implement this new step
    #create lagin method in Webtableloginpage
    #this login method should have multiple different overloaded version


  Scenario: user should be able to see all 12 months in
  months
  dropdown

    When User enters below credentials
      | username | Test   |
      | password | Tester |
    Then user should see url contains orders
