@location_service
Feature: Location service

  @get_all
  Scenario: GET all locations

    Given the application is running
    When I get all locations
    Then I should see "LON" location in the response
    Then I should see "MAN" location in the response
    Then I should see "CAM" location in the response
    Then I should see "LCS" location in the response

  @get
  Scenario: GET a location

    Given the application is running
    When I get the "LON" location
    Then I should see response schema is correct
    When I get the "MAN" location
    Then I should see response schema is correct
    When I get the "CAM" location
    Then I should see response schema is correct
    When I get the "LCS" location
    Then I should see response schema is correct

  @get_not_existent
  Scenario: GET non-existent location

    Given the application is running
    When I get the "LIV" location
    Then I should see server error

  @post
  Scenario: POST a location

    Given the application is running
    When I post the "PAC" location
    Then I should see "PAC" location in the response


