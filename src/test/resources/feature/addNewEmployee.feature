Feature: Verify Employee add E2E functionaity
  
  
  $s1="TestingPurpose";

  #@Datasetup
  Scenario: Verify User able to add superviosr
    Given User can login the application as admin user
    And User can click the PIM button in Side menu bar, after clicking user able to see the following options Configuration Employee List Add Employee Reports as top menu
    When User click on Add Employee button on the top menu and user able to see all required field
    And User fill First name as "Supervisor-02" last name as "Supervisor-02" and click save button
    When User can go to add employee tab and click add button then fill the FirstName,LastName, Employee_ID and click save button
      | FirstName  | LastName | EmpID |
      | Vinoth0111 | Kumar011 |  1400 |
      | Vinoth0112 | Kumar012 |  1401 |
    Then Veify record saved successfully

  #@Datasetup02
  Scenario Outline: Verify admin able to add superviosr along with credential
    Given User can login the application as admin user
    And User can click the PIM button in Side menu bar, after clicking user able to see the following options Configuration Employee List Add Employee Reports as top menu
    When User click on Add Employee button on the top menu and user able to see all required field
    And User fill First name as "Supervisor-01" last name as "Supervisor-01" and click save button
    Then Verify user successfully saved message
    And User can click the Admin link on the side tab
    And User can click the User management on the top menu
    And user can click the users option in the user management tab
    When user can click the add button
    And user can fill all required field "Supervisor-01" "Supervisor-01" "Spring*123" and click save button
    Then Verify user successfully saved message

  #@Datasetup02
  Scenario: Verify supervisor able to login the application
    Given user enter the username as "Supervisor-02" and password as "Spring*123"
    When User click login button
    Then Verify the profile name that user should match with user full name as "Supervisor-02 Supervisor-02"

  @Datasetup02
  Scenario Outline: Verify user able to add new employee
    Given User can login the application as admin user
    And User can click the PIM button in Side menu bar, after clicking user able to see the following options Configuration Employee List Add Employee Reports as top menu
    When User click on Add Employee button on the top menu and user able to see all required field
    #And User fill First name as "Employee-01" last name as "Employee-01" and click save button
    And User fill First name as <FirstName> last name as <LastName> and click save button
    #And User fill person details Driver License Number as "TN504578615" Nationality as "Latvian" Marital Status as "Married" Date of Birth as "2024-04-27" Gender as "Male" and click save button
    And User fill person details Driver License Number as <DL-Nummber> Nationality as <Nationality> Marital Status as <Marital_Status> Date of Birth as <DOB> Gender as <Gender> and click save button
    #And User fille supervisor name as "Supervisor-01 Supervisor-01" and reporting to as Dirct "0" and click save
    And User fille supervisor name as <SupervisorName> and reporting to as Dirct <hierarci> and click save

    Examples: 
      | FirstName   | LastName    | DL-Nummber | Nationality | Marital_Status | DOB        | Gender | SupervisorName              | hierarci |
      | Employee-01 | Employee-01 | T50124594  | Indian      | Married        | 2024-04-27 | Male   | Supervisor-01 Supervisor-01 |        0 |
