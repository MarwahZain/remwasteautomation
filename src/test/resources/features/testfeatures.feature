Feature: User authentication and management


  Background:
    Given the user opens the application

  @Login
  Scenario: Login with valid credentials
    When the user logs in with valid credentials
    Then the dashboard should be displayed
    And a welcome message should be visible

  @Login
  Scenario: Login with invalid credentials
    When the user logs in with username "wrong@example.com" and password "wrongpass"
    Then an error message "Invalid credentials" should be displayed


  @Create
  Scenario: Create a new user item
    Given the user is logged in
    When the user creates a new item with name "Test Task"
    Then the item "Test Task" should appear in the list

  @Edit
  Scenario: Edit an existing item
    Given the user is logged in
    And the item "Test Task" exists
    When the user edits the item "Test Task" to "Updated Task"
    Then the item "Updated Task" should be visible in the list

  @Delete
  Scenario: Delete an item
    Given the user is logged in
    And the item "Updated Task" exists
    When the user deletes the item "Updated Task"
    Then the item "Updated Task" should not appear in the list

  @AssertData
  Scenario: Assert user data after login
    Given the user is logged in
    Then the user's name "Test User" should be visible
    And the email "testuser@example.com" should be shown