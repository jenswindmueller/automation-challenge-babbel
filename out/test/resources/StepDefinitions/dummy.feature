Feature: Test addition using Google Calculator


  Scenario Outline: Test 2 number addition
    Given Open google.com
    When Clicking on reject all button
    When Entering number <firstNumber> and <secondNumber>
    Then Close web driver

    Examples:
      | firstNumber | secondNumber | result |
      | 6           | 6            | 12     |
#      | 6           | 2            | 9      |
#      | 8           | 5            | 13     |