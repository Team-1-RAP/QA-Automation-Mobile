@regression @login
Feature: Login

  Scenario: User access Lupa Password
    Given The user open Simple Bank apps
    When The user is on Login page
    And On Login page, The user click "Lupa Password?" button
    Then The user verify redirected to Lupa Password page

  Scenario: User access Biometrik login
    Given The user open Simple Bank apps
    When The user is on Login page
    And On Login page, The user click "Biometrik" button
    Then The user verify pop up biometrik is displayed

  Scenario: User can show or hide password
    Given The user open Simple Bank apps
    When The user is on Login page
    And On Login page, The user input "test.mobile" in username
    And On Login page, The user input "Password2024!" in password
    Then The user verify can show password
    And The user verify can hide password

  Scenario: Login with valid username and invalid password
    Given The user open Simple Bank apps
    When The user is on Login page
    And On Login page, The user input "qa.mobile" in username
    And On Login page, The user input "Invalid2024!" in password
    And On Login page, The user click "Login" button
    Then The user verify login failed

  Scenario: Login with invalid username and valid password
    Given The user open Simple Bank apps
    When The user is on Login page
    And On Login page, The user input "qa.invalid" in username
    And On Login page, The user input "Password2024!" in password
    And On Login page, The user click "Login" button
    Then The user verify login failed

  Scenario: Login with valid username and valid password
    Given The user open Simple Bank apps
    When The user is on Login page
    And On Login page, The user input "test.mobile" in username
    And On Login page, The user input "Password2024!" in password
    And On Login page, The user click "Login" button
    Then The user verify login success
