Feature: API response validation against JSON schema

  Scenario Outline: schema response validation
    Given I hit the url of get USD endpoint
    When I send <valid> request
    Then I validate response against JSON schema
    Examples:
      | valid |
      | USD   |

  Scenario Outline: response validation - currency pair count
    Given I hit the url of get USD endpoint
    When I send <valid> request
    Then I validate <number> currency pairs are returned
    Examples:
      | valid | number |
      | USD   | 162    |
