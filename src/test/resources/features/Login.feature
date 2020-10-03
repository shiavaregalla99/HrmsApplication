Feature: Login Functionality
@smoke
Scenario: Login into the application by providing valid credentials

Given User enters the Login application
When  User enter valid username and valid password
And   User click on the login button
Then  User successfully logged in

@smoke1
Scenario Outline: Error message validation while invalid login

Given User enters the Login application
When  User enter "<Username>" and "<Password>"
And   User click on the login button
Then  User should see "<ErrorMessage>"

Examples:
|Username |   Password|   ErrorMessage|
|user1    |admin123   |Invalid credentials|
|admin    |admin1234  |Invalid credentials|
|Admin    |           |Password cannot be empty|
|         |admin123   |Username cannot be empty|

