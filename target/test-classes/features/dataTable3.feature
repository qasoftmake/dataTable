Feature:  Facebook registration 1
  Verify the new user registration is unsuccessful after passing incorrect inputs

  @FunctionalTest
  Scenario: Registration failed - feature 1
    Given I am on the new user registration page
    When I enter invalid data on the page
      | Fields       | Values           |
      | firstName    | Randomfirst      |
      | lastName     | randomlast       |
      | phoneOrEmail | someone@test.com |
      | password     | randompass       |
      | dayOfBirth   | 12               |
      | monthOfBirth | 6                |
      | yearOfBirth  | 2005             |
      | Gender       | Male             |

    Then The user registration should be unsuccessful

  @SmokeTest
  Scenario: Successful Registration - feature 1
    Given I am on the new user registration page
    When I enter invalid data on the page
      | Fields       | Values           |
      | firstName    | Randomfirst      |
      | lastName     | randomlast       |
      | phoneOrEmail | someone@test.com |
      | password     | randompass       |
      | dayOfBirth   | 12               |
      | monthOfBirth | 6                |
      | yearOfBirth  | 2005             |
      | Gender       | Male             |

    Then The user registration should be unsuccessful

  @RegressionTest
  Scenario: Scenario three - feature 1
    Given I am on the new user registration page
    When I enter invalid data on the page
      | Fields       | Values           |
      | firstName    | Randomfirst      |
      | lastName     | randomlast       |
      | phoneOrEmail | someone@test.com |
      | password     | randompass       |
      | dayOfBirth   | 12               |
      | monthOfBirth | 6                |
      | yearOfBirth  | 2005             |
      | Gender       | Male             |

    Then The user registration should be unsuccessful

  @RegressionTest @FunctionalTest
  Scenario: Scenario four - feature 1
    Given I am on the new user registration page
    When I enter invalid data on the page
      | Fields       | Values           |
      | firstName    | Randomfirst      |
      | lastName     | randomlast       |
      | phoneOrEmail | someone@test.com |
      | password     | randompass       |
      | dayOfBirth   | 12               |
      | monthOfBirth | 6                |
      | yearOfBirth  | 2005             |
      | Gender       | Male             |

    Then The user registration should be unsuccessful