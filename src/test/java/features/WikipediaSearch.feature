Feature: Wikipedia Search
  I am a user
  I want to search for articles
  in order to see it's content

  Background: Initial page is displayed
    Given the Main Page is displayed

  Scenario: Download PDF
    When I input 'Albert Einstein' text in the search field and click submit button
    And I click Tool menu button and Download as PDF button on the Article page
    And I download file from Download as PDF page
    Then The file with the name provided on Download as PDF page is downloaded

  Scenario: Get Page information
    When I input 'Albert Einstein' text in the search field and click submit button
    And I click Tool menu button and Page information button on the Article page
    Then the Information page for Albert Einstein article is displayed

  Scenario: Change search language
    When I input 'Albert Einstein' text in the search field, change search language to 'Español' and click submit button
    Then The article page for 'Albert Einstein' is open.


