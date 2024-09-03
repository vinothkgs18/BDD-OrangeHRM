Feature: Setup the data for our testing
#@Datasetup
  Scenario: Added new employee with Fist and Last name
    Given User can login the application as admin user
    When User can click the PIM menu link in Side menu
    And User can go to add employee tab and click add button then fill the FirstName,LastName and Employee_ID
      | FirstName | LastName | EmpID |
      | Vinoth0111 | Kumar011 |  1400 |
      | Vinoth0112 | Kumar012 |  1401 |
      | Vinoth0113 | Kumar013 |  1402 |
      | Vinoth0114 | Kumar014 |  1402 |
      | Vinoth0115 | Kumar015 |  1402 |
      | Vinoth0116 | Kumar016 |  1402 |
      | Vinoth0117 | Kumar017 |  1402 |
      | Vinoth018 | Kumar018 |  1402 |
      | Vinoth019 | Kumar019 |  1402 |
      | Vinoth020 | Kumar020 |  1402 |
      | Vinoth021 | Kumar021 |  1402 |
      | Vinoth022 | Kumar022 |  1402 |
      | Vinoth023 | Kumar023 |  1402 |
      | Vinoth024 | Kumar024 |  1402 |
      | Vinoth025 | Kumar025 |  1402 |
      | Vinoth026 | Kumar026 |  1402 |
      | Vinoth027 | Kumar027 |  1402 |
      | Vinoth028 | Kumar028 |  1402 |
      | Vinoth029 | Kumar029 |  1402 |
      | Vinoth030 | Kumar030 |  1402 |
      | Vinoth031 | Kumar031 |  1402 |
    Then Veify record saved successfully

@Datasetup01
  Scenario: Add new employee with all personal details, job details and Report Details
    Given User can login the application as admin user
    When User can click the PIM menu link in Side menu
    And User can go to Add Employee tab and fill all required filed then click save button then fill remain all required field under personl job and Report-to section click save
    
    
      | FirstName | LastName | SSN_Number   | Nationality | Marital Status | DOB        | Gender | Joined_Date | Job Title | Employment Status   | SupervisorName | Reporting_Method |
      | Babu      | Sundar   | 207082284671 | Indian      | Married        | 1991-01-19 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |
      | Raja2     | Devan    | 207082284671 | Indian      | Married        | 1991-01-20 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |
      | Raja3     | Devan    | 207082284671 | Indian      | Married        | 1991-01-21 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |
      | Raja4     | Devan    | 207082284671 | Indian      | Married        | 1991-01-22 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |
      | Raja5     | Devan    | 207082284671 | Indian      | Married        | 1991-01-23 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |
      | Raja6     | Devan    | 207082284671 | Indian      | Married        | 1991-01-24 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |
      | Raja7     | Devan    | 207082284671 | Indian      | Married        | 1991-01-25 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |
      | Raja8     | Devan    | 207082284671 | Indian      | Married        | 1991-01-26 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |
      | Raja9     | Devan    | 207082284671 | Indian      | Married        | 1991-01-27 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |
      | Raja10    | Devan    | 207082284671 | Indian      | Married        | 1991-01-28 | Male   | 2024-01-01  | QA        | Full Time Permenant | Babu Sundar    | Direct           |

#@Datasetup
  Scenario: Verify the search result in EmployeeListPage search By name
    Given User can login the application as admin user
    When User can click the PIM menu link in Side menu
    And User click can click on Employee list Tab
    And User enter the emplyee name as "Vinoth" in employee name field and click search button
    Then Verify user get "21" record in result based on search key
