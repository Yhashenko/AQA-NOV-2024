Feature: params demo

  Scenario: Data Table demo
    Given I print a String "my string to print"
    Given I print a String "my string to print" 5 times
    Given Data Table "my table" values:
      | asd1 |
      | asd2 |
      | asd3 |

    Given Data Table "my table as map" values as map:
      | key_1 | value_1 |
      | key_2 | value_2 |

