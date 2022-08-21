Feature: Babbel's QA app

@appium
  Scenario Outline: User checks if text appears after clicking Click Me button below Welcome text
    Given User Logs in to QA App with "<email>" and "<password>"
    When User is logged in successfully
    And User clicks On CLick Me button below the Image
    And User clicks On Click me button below the Welcome text
    Then User checks if a Text appears

  Examples:
   | email               | password |
   | arthur@gmail.com    | 98765    |
   | percival@gmail.com  | 123456   |
