Feature: Get and Validate response from API

  Scenario Outline: Verify response code for get API call
    Given I hit the url of get USD endpoint
    When I send <valid> request
    Then I validate response has <code> code
    Examples:
      | valid | code |
      | USD   | 200  |
      | 45    | 404  |

  Scenario Outline: Verify status message for get API call
    Given I hit the url of get USD endpoint
    When I send <valid> request
    Then I validate the status <status>
    Examples:
      | valid | status  |
      | USD   | success |
      | XYZ   | error   |

  Scenario Outline: Verify base rates of one currency (AED) against another (USD) and range
    Given I hit the url of get USD endpoint
    When I send <valid> request
    Then I validate the rest of <currency> against USD is in range <minRate> and <maxRate>
    Examples:
      | valid | currency | minRate | maxRate |
      | USD   | 'AED'    | 3.6     | 3.7     |

  Scenario Outline: Verify response time with given time
    Given I hit the url of get USD endpoint
    When I send <valid> request
    Then I validate response time is less than <timeVerify>
    Examples:
      | valid | timeVerify |
      | USD   | "3000L"    |

