Feature: Verify all the functionality under the PIM page
  
  |College|
  |DGVC|

@Run
  Scenario Outline: TC01_User can able to add new employee with firstName and last name alone
    Given User can login the application as admin user
    When User can click the PIM menu link in Side menu
    And User can click the Add Employee tab
    And User can fill the "<FirstName>","<LastName>","<Employee_ID>"
    Then Veify record saved successfully

    Examples: 
      | FirstName | LastName | Employee_ID |
      | Vinoth01  | Kumar01  |        1403 |
  
  Scenario Outline: User can able to add new employee with credentials information
  Given User can login the application as admin user
    When User can click the PIM menu link in Side menu
    And User can click the Add Employee tab
    And User can fill the "<FirstName>","<LastName>","<Employee_ID>"
    And user click the check box for Create Login Details and provide the username as "vinoth01" password as "Spring*123"
     Examples: 
      | FirstName | LastName | Employee_ID |
      | Vinoth01  | Kumar01  |        1403 |
