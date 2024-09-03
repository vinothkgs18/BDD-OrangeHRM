Feature: Verify Login functionality

$test=Vinoth

@test
Scenario: Verify user able to login the applicatio
Given user is on login page
When User enter the ${<test>} and "Password" and click login
Then user navigate to home page