Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check correctness of search result with valid input data
    Given User opens '<homePage>'
    When User makes search by '<keyword>'
    And User clicks search button
    Then User checks that '<searchResult>' is correct

    Examples:
      | homePage                | keyword    | searchResult |
      | https://www.amazon.com/ | cell phone | "cell phone" |

  Scenario Outline: Check correctness of search result with invalid input data
    Given User opens '<homePage>'
    When User makes search by '<keyword>'
    And User clicks search button
    Then User checks that there is '<noSearchResult>'

    Examples:
      | homePage                | keyword | noSearchResult |
      | https://www.amazon.com/ | 浮渣      | No results     |

  Scenario Outline: Check amount of items in cart after adding item to cart
    Given User opens '<homePage>'
    And User clicks *all* button
    And User choose *electronic* class items
    And User choose *cell phones and accessories*
    And User clicks *cell phones* filter
    And User clicks on the first phone
    And User clicks on the *add to cart* button
    Then User checks '<amountOfItems>' in cart

    Examples:
      | homePage                | amountOfItems |
      | https://www.amazon.com/ | 1             |

  Scenario Outline: Check to sign-in with invalid input data
    Given User opens '<homePage>'
    And User clicks sign-in link
    When User input '<keyword>'
    Then User checks that '<expectedMessage>' appears

    Examples:
      | homePage                | keyword   | expectedMessage     |
      | https://www.amazon.com/ | !!!!!!!!! | There was a problem |

  Scenario Outline: Check of currency changing
    Given User opens '<homePage>'
    And User clicks *all* button
    And User checks visibility of *electronic* class items
    And User choose *electronic* class items
    And User checks visibility of *cell phones and accessories*
    And User choose *cell phones and accessories*
    And User clicks *cell phones* filter
    And User clicks on the first phone
    And User clicks on the *language* button
    And User clicks on the *currency format change* button
    And User choose Russian ruble
    And User clicks on the *save changes* button
    Then User checks '<expectedValueOfPrice>'

    Examples:
      | homePage                | expectedValueOfPrice |
      | https://www.amazon.com/ | RUB 90,938.11        |

  Scenario Outline: Check amount of elements declared on the page
    Given User opens '<homePage>'
    And User clicks *all* button
    And User checks visibility of *electronic* class items
    And User choose *electronic* class items
    And User checks visibility of *cell phones and accessories*
    And User choose *cell phones and accessories*
    When User clicks *cell phones* filter
    Then User checks amount of '<expectedAmountOfElements>'

    Examples:
      | homePage                | expectedAmountOfElements |
      | https://www.amazon.com/ | 24                       |

  Scenario Outline: Check searching item by price filter
    Given User opens '<homePage>'
    And User clicks *all* button
    And User checks visibility of *electronic* class items
    And User choose *electronic* class items
    And User checks visibility of *cell phones and accessories*
    And User choose *cell phones and accessories*
    When User enters '<keyword>' to min and max price filter
    And User clicks *go* button
    Then User checks correct '<expectedAmountOfItems>'

    Examples:
      | homePage                | keyword | expectedAmountOfItems |
      | https://www.amazon.com/ | 3500    | 1                     |

  Scenario Outline: Check input price more than max price available
    Given User opens '<homePage>'
    And User clicks *all* button
    And User checks visibility of *electronic* class items
    And User choose *electronic* class items
    And User checks visibility of *cell phones and accessories*
    And User choose *cell phones and accessories*
    When User enters more than max price '<keyword>' to min and max price filter
    And User clicks *go* button
    Then User checks appeared '<expectedMessage>'

    Examples:
      | homePage                | keyword | expectedMessage                                      |
      | https://www.amazon.com/ | 4000    | Try checking your spelling or use more general terms |

  Scenario Outline: Check filter that shows items with price under 25 dollars
    Given User opens '<homePage>'
    And User clicks *all* button
    And User checks visibility of *electronic* class items
    And User choose *electronic* class items
    And User checks visibility of *cell phones and accessories*
    And User choose *cell phones and accessories*
    When User clicks on filter that shows items with price less then twentyfive dollars
    Then User checks that there is no price more then '<boundOfPrice>'

    Examples:
      | homePage                | boundOfPrice |
      | https://www.amazon.com/ | 25           |