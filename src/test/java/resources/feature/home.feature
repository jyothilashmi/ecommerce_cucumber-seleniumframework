#Author: your.email@your.domain.com

@tag
Feature: Homepage feature

Background:
    Given User is on the login page
    And User logs in with valid credentials

  @tag1
  Scenario: Verify all links in homepage are working
    Given User is in homepage
    When User extracts all the links
    Then Verify each link returns successful response
