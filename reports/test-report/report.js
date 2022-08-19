$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/dummy.feature");
formatter.feature({
  "name": "Test addition using Google Calculator",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Test 2 number addition",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Open google.com",
  "keyword": "Given "
});
formatter.step({
  "name": "Entering number \u003cfirstNumber\u003e and \u003csecondNumber\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Press enter",
  "keyword": "And "
});
formatter.step({
  "name": "Result should be \u003cresult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "firstNumber",
        "secondNumber",
        "result"
      ]
    },
    {
      "cells": [
        "6",
        "6",
        "12"
      ]
    },
    {
      "cells": [
        "6",
        "2",
        "9"
      ]
    },
    {
      "cells": [
        "8",
        "5",
        "13"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Test 2 number addition",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open google.com",
  "keyword": "Given "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.open_google_com()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Entering number 6 and 6",
  "keyword": "When "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.entering_number_and(java.lang.Integer,java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Press enter",
  "keyword": "And "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.press_enter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Result should be 12",
  "keyword": "Then "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.result_should_be(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Test 2 number addition",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open google.com",
  "keyword": "Given "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.open_google_com()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Entering number 6 and 2",
  "keyword": "When "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.entering_number_and(java.lang.Integer,java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Press enter",
  "keyword": "And "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.press_enter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Result should be 9",
  "keyword": "Then "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.result_should_be(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Test 2 number addition",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open google.com",
  "keyword": "Given "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.open_google_com()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Entering number 8 and 5",
  "keyword": "When "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.entering_number_and(java.lang.Integer,java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Press enter",
  "keyword": "And "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.press_enter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Result should be 13",
  "keyword": "Then "
});
formatter.match({
  "location": "com.template.ui.StepDefinitionsTemplate.result_should_be(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});