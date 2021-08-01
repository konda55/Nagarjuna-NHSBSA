@NHSBSA
Feature: NHSBSA Eligibility Checker
  Scenario: Check eligibility for NHS help
    Given I am a citizen of the UK
    When I put my circumstances into the Checker tool
    Then I should get a result of whether I will get help or not