@regression @logout
Feature: 07 Logout

  Scenario: User can logout
    Given The user already on Home page
    When On Home page, The user click "Profil" menu
    And The user redirected to Profile page
    And The user click Logout button
    And The user click Iya button
    Then The user is on Login page