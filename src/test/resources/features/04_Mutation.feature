@regression @mutasi
Feature: 03 Mutation

  Scenario: User can access Mutasi menu
    Given The user already on Home page
    When On Home page, The user click "Mutasi" menu
    Then The user redirected to Mutasi page

  Scenario: User apply filter mutation by month
    Given The user already on Home page
    When On Home page, The user click "Mutasi" menu
    And The user redirected to Mutasi page
    And On Mutasi page, The user click "Month" filter
    And On Mutasi page, The user click "Juli" in filter by month
    And On Mutasi page, The user click "Month" filter
    And On Mutasi page, The user click "Agustus" in filter by month
    And The user verify the filter is applied

  Scenario: User apply filter mutation by type pemasukan
    Given The user already on Home page
    When On Home page, The user click "Mutasi" menu
    And The user redirected to Mutasi page
    And On Mutasi page, The user click "Type" filter
    And On Mutasi page, The user click "Pemasukan" in filter by type
    And The user verify the filter is applied

  Scenario: User apply filter mutation by type pengeluaran
    Given The user already on Home page
    When On Home page, The user click "Mutasi" menu
    And The user redirected to Mutasi page
    And On Mutasi page, The user click "Type" filter
    And On Mutasi page, The user click "Pengeluaran" in filter by type
    And The user verify the filter is applied