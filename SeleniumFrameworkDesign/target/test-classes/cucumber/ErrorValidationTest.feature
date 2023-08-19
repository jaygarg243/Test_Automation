@tag
Feature: Error Validation

Background:
Given I landed on Ecommerce Page


  @tag2
  Scenario Outline: Error Validation
    Given Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    
    Examples: 
      | name  						 |     password       |
      | jayash@hotmail.com |     Asdfgh@1 		  |