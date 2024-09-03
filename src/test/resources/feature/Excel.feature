Feature: Verify excel integration working properly

  @excel
  Scenario: Verify excel data generated with sysout method
    Given User connected below excel file
      | SheetUrl                            | Row |
      | ./src/test/resources/data/test.xlsx |   0 |
