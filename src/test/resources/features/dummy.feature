Feature: Test addition using Google Calculator


  Scenario Outline: Test 2 number addition
    Given Open google.com
    When Clicking on reject all button
    When Entering number <firstNumber> and <secondNumber>

    Examples:
      | firstNumber | secondNumber |
      | 6           | 6            |