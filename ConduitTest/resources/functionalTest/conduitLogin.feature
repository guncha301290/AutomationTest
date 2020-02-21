@reg
Feature: Login Application

Scenario: Login

		Given I am on the Conduit Home Page
		And I click on SIGN IN
		And Need an account text is displayed
		When I login with incorrect credentials
		And Error Message is displayed
		Then I login with correct credentials
		And I am taken to the Account Page
		
		
  
