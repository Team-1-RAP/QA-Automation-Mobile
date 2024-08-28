@regression @transfer
Feature: 03 Transfer

  Scenario: User can access Transfer menu
    Given The user already on Home page
    When On Home page, The user click "Transfer" menu
    Then The user redirected to Transfer page

  Scenario: User can add new transfer
    Given The user already on Home page
    When On Home page, The user click "Transfer" menu
    And The user redirected to Transfer page
    And On Transfer page, The user click "Transfer Baru" button
    And On Transfer page, The user select top Rekening Sumber
    And On Transfer page, The user input "BCA" as Bank Tujuan
    And On Transfer page, The user input "0120000027" as Rekening Tujuan
    And On Transfer page, The user input "Automation Test" as Keterangan
    And On Transfer page, The user click "Selanjutnya" button
    And On Transfer page, The user verify preview Rekening Tujuan is correct
    And On Transfer page, The user input "11111" as Nominal
    And On Transfer page, The user input "Automation Test" as Keterangan
    And On Transfer page, The user click "Selanjutnya" button
    And On Transfer page, The user verify data in Konfirmasi Transfer is correct
    And On Transfer page, The user input "123456" as Pin
    And On Transfer page, The user click "Transfer" button
    Then The user verify transfer is success