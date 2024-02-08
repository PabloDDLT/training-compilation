Feature: City Weather Search
  I am a user
  I want to search for cities
  in order to see it's weather

  Background: Initial page and data usage
    Given the Main page is open
    When I consent to data usage in the banner
    Then the consent for data usage is accepted

  Scenario: Search for City Weather
    When I input 'New York' in the search field
    Then the search results list is displayed
    And I click on the first search result
    Then the City Weather page header contains the city name from the search

  Scenario: View Weather for a Recently Searched City
    When I input 'London' in the search field
    Then the search results list is displayed
    And I click on the first search result
    Then the City Weather page header contains the city name from the search
    And I go back to the main page
    Then the Main page is opened
    And I choose the first city in Recent locations
    Then the City Weather page header contains the city name from the recent locations

  Scenario: Search for City and Use Current Location
    When I click the search field on the main page
    Then the search results list is displayed
    And the "Use your current location" label is displayed