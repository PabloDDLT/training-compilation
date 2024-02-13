Feature: City Weather Search
  I am a user
  I want to search for cities
  in order to see it's weather

  Background: Initial page and data usage
    Given I consent to data usage in the banner

  Scenario: Search for City Weather
    When I input 'New York' in the search field
    Then the search results list is displayed
    When I click on the first search result
    Then the City Weather page header contains 'New York'

  Scenario: View Weather for a Recently Searched City
    When I input 'London' in the search field
    And I click on the first search result
    When I go back to the main page
    Then the Main page is opened
    When I choose the first city in Recent locations
    Then the City Weather page header contains 'London'

  Scenario: Search for City and Use Current Location
    When I click the search field on the main page
    Then the search results list is displayed
    And the 'Use your current location' label is displayed
