Feature: Example of Cucumber data table implementations

  Scenario: List of fruits I like
    Then user should see fruits I like
      | kiwi        |
      | banana      |
      | cucumber    |
      | orange      |
      | mango       |
      | grape       |
      | pomegranate |

    #to make on a line
    #mac command+options +L
    #Widows alt+ctrl+L
