
@tag
Feature: Purchase the order from ecommerce website

Background:
Given I landed on Ecommerce Page


  @tag2
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And checkout product <productName> and submit the order
    Then "Thankyou for the order." message is displayed on confirmation page
     
    Examples: 
      | name  						 |     password       |  productName  |
      | jayash@hotmail.com |     Asdfgh@123 		|  ZARA COAT 3  |
      
