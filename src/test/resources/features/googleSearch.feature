Feature: Google search functionality
  Agile story:When I am on the Google search page
  I should be able to search whatever I want and see relevant information

  Scenario: Search page title verification
    When user is on Google search page
    Then user should see title Google

@wip
    Scenario: Search functionality result title verification
      Given user is on Google search page
      When user writes apple and click enter
      Then user sees apple in Google title


  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user writes "apple" and click enter
    Then user sees "apple" in Google title
