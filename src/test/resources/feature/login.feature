Feature: Verify login functionality

  Scenario: Verify login functionality with bad credential
    Given user enter the username as "admin" and password as "admin@789"
    When User click login button
    Then verify the error message as "Invalid credentials"

  Scenario: Verify login functionality with valid credential
    Given user enter the username as "Admin" and password as "admin123"
    When User click login button
    Then verify the page is redirect to dashboard page

    Scenario: Verify lgoin functioanlity without enter the username and password
    Given User click login button
    Then Verify error warning message in both user name and password field