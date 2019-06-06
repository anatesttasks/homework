Feature: Sorting functionality on Housing page

  Scenario: On the Housings page by default such sorting possibilities are available: price ⬆️, price ⬇️, newest
    Given guest is on Home page
    When guest chooses an english as UI language
    And guest clicks on Housings link
    Then Housing page should open
    And the following sorting types are available:
      | date | priceasc | pricedsc |

  Scenario: On the Housings page after using search such sorting possibilities are available: price ⬆️, price ⬇️, newest, upcomming, relavent
    Given guest is on Home page
    When guest chooses an english as UI language
    And guest clicks on Housings link
    Then Housing page should open
    When guest searches for Housing offers by 500
    And the following sorting types are available:
      | date | priceasc | pricedsc | upcoming | rel |

  Scenario Outline: On the Housings page guest can sort records by price
    Given guest is on Home page
    When guest chooses an english as UI language
    And guest clicks on Housings link
    Then Housing page should open
    When guest enables sorting by <sortingType>
    Then all records are sorted by <sortingType>
    When guest searches for Housing offers by room
    Then all records are sorted by <sortingType>

    Scenarios:
    | sortingType |
    | priceasc    |
    | pricedsc    |