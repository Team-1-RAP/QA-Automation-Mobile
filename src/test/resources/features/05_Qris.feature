@regression @qris
Feature: 05 Qris

  Scenario: User can access Qris menu
    Given The user already on Home page
    When On Home page, The user click "Qris" menu
    Then The user redirected to Qris page

  Scenario: User can click Galery button in scan kode
    Given The user already on Home page
    When On Home page, The user click "Qris" menu
    And The user redirected to Qris page
    Then On Scan Code page, The user click "Galery" button

  Scenario: User can click Flash button in scan kode
    Given The user already on Home page
    When On Home page, The user click "Qris" menu
    And The user redirected to Qris page
    Then On Scan Code page, The user click "Flash" button

  Scenario: User can access qris show code
    Given The user already on Home page
    When On Home page, The user click "Qris" menu
    And The user redirected to Qris page
    And The user click Show Code section
    Then The user redirected to Show Code section

  Scenario: User can create qris show code
    Given The user already on Home page
    When On Home page, The user click "Qris" menu
    And The user redirected to Qris page
    And The user click Show Code section
    And The user redirected to Show Code section
    And The user select top rekening in Pilih Rekening
    And The user input "11111" in Nominal
    And The user click Selanjutnya button
    And The user input "123456" in Pin
    Then The user verify qris show code displayed