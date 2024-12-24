Feature: Test allo.ua search

  Scenario: search for iphone
    Given I store those phones to database
    When I request database for a random phone
    Then I can see that phone's name
    Given I load allo.ua page
    When I request for 3 random phones from allo.ua website
    Then I can see at least 3 search results


