Feature: User Creation Feature allows to create new users and read them later

  Scenario: Creating simple user and validate that it's saved in user API
    Given Create user API is provided
    When Creating user John with age 12 calling user API
    Then User Api returns John user with 12 age

  Scenario: Failing to create to the user with same name twice
    Given Create user API is provided
    When Creating user John with age 12 calling user API
    Then Fail to create user John with age 13 when calling user API

  Scenario: Failing to create to the same user twice
    Given Create user API is provided
    When Creating user John with age 12 calling user API
    Then Fail to create user John with age 13 when calling user API

  Scenario: Creating multiple users and check that all of them are available
    Given Create user API is provided
    When Creating multiple users
      | name   | age |
      | Peter  | 32  |
      | Martha | 33  |
    Then All created users now available from user API
      | name   | age |
      | Peter  | 32  |
      | Martha | 33  |











