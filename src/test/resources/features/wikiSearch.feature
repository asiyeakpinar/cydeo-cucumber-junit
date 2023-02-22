
@wikipedia
Feature: Wikipedia search functionality and verification
  # WSF-45234 (if you want to put ticket number here)

  Scenario: Wikipedia Search Functionality Title Verification
  Given User is on Wikipedia home page
  When  User types "Steve Jobs" in the wiki search box
  And   User clicks wiki search button
  Then  User sees "Steve Jobs" is in the wiki title

Scenario: Wikipedia Search Functionality Header Verification
Given User is on Wikipedia home page
When User types "Steve Jobs" in the wiki search box
And User clicks wiki search button
Then User sees "Steve Jobs" is in the main header


Scenario: Wikipedia Search Functionality Image Header Verification
Given User is on Wikipedia home page
When User types "Steve Jobs" in the wiki search box
And User clicks wiki search button
Then User sees "Steve Jobs" is in the image header


@scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When  User types "<searchValue>" in the wiki search box
    And   User clicks wiki search button
    Then  User sees "<expectedTitle>" is in the wiki title
    #Then User sees "<expectedMainHeader>" is in the image header

    Examples: Search values we are going to be using in this scenario as below

     |searchValue|expectedTitle|expectedMainHeader|
     |Steve Jobs |Steve Jobs   |Steve Jobs        |
     |Cristiano Ronaldo|Cristiano Ronaldo|Cristiano Ronaldo|
     |Marie Curie     |Marie Curie       |Marie Curie       |
     |Lady Gaga       |Lady Gaga         |Lady Gaga         |
     |Chuck Norris    |Chuck Norris      |Chuck Norris      |
     |Harry Potter    |Harry Potter      |Harry Potter      |

