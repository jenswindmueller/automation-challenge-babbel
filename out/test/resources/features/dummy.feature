Feature: Test addition using Google Calculator

  @web
  Scenario Outline: The User types 6 + 6 in to google search
    Given User is on Home Page
    When Clicking on reject all button
    When Entering number <firstNumber> and <secondNumber>

    Examples:
      | firstNumber | secondNumber |
      | 6           | 6            |