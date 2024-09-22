Feature: Verify the all functionality which available in user management user screen

  Background: 
    Given User can login the application as admin user
    And User can click the Admin link on the side tab
    And User can click the User management on the top menu
    And user can click the users option in the user management tab

  Scenario: User able to search the user by valid user name
    When User enter the user name as "admin" and click the search button
    Then Verify user should getting the result that match with our search keyword

  Scenario: User able to search the user by user role
    When User select the admin from the User Role dropdown
    Then Verify the search result

  Scenario: User able to add new user by clicking add button
    When user can click the add button
    And user can fill all required field "Vinoth" "Vinothkgs" "Spring*123" and click save button
    Then Verify user successfully saved message

  Scenario: User is able to elete the particular record
    Given User can select the any record and click the delete button on the top
    Then verify success message for delete action

  Scenario: User able to search the employee by employee name
    When User enter the name as "Vinoth Kumar" in the employee name field and select the first suggesstion
    And Click the search button
    Then Verify the employee name "Vinoth Kumar" that match with search critria

  Scenario: User is able to search the employee by name and status
    When User enter the name as "Vinoth Kumar" and select "Enabled"
    And Click the search button
    Then Verify the employee Result row count

  Scenario: User is able to search the employee by username userRole EmployeeName and status
    When user fill all fields userName as "vinoth" userRole as "ESS" employeeName as "Vinoth Kumar" and status as "Enabled"
    And Click the search button
    Then Verify the employee Result row count

  @Debug
  Scenario: User able to reset the data by clicking the reset button
    When user fill all fields userName as "vinoth" userRole as "ESS" employeeName as "Vinoth Kumar" and status as "Enabled"
    And Click the search button
    And user click the reset button
    Then Verify the employee Result row count
