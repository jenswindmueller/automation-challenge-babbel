Feature: Hello World.

@appium
  Scenario: User checks if .
    Given User Logs in to QA App
    When User is logged in sucessfully
    And User clicks On CLick me button below the Image
    And User clicks On Click me button below the Welcome text
    Then User Sees a Text appear and disapear again
