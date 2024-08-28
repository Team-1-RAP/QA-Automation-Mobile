@regression @checkBalance
Feature: 02 Check Balance

  Scenario: User can show balance
    Given The user already on Home page
    When On Home page, The user click "Show" balance icon
    Then On Home page, The user verify balance is show

  Scenario: User can hide balance
    Given The user already on Home page
    When On Home page, The user click "Show" balance icon
    Then On Home page, The user verify balance is show
    When On Home page, The user click "Hide" balance icon
    Then On Home page, The user verify balance is hide