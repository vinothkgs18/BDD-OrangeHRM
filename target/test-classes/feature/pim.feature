Feature: Verify all the functionality under the PIM page

Scenario: Verify user is able to add the new employee with all personal data
    Given User can login the application as admin user
    When User can click the PIM menu link in Side menu
    And User can click the Add Employee tab
    And User can fill the "<FirstName>","<LastName>" and "<Employee_ID>"
    Then Veify record saved successfully