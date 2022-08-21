Feature: Test addition using Google Calculator

  @web
  Scenario: User translates a german text into english using the Detect Language feature of deepl
    Given User visits deepl translator
    When User views languages to translate to
    And User selects "English" to translate
    And User enters text to be translated
    Then User checks if "German" was auto detected