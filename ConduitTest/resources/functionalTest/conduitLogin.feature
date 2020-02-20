@reg
Feature: Login Application

Scenario: Login

		Given I am on the Conduit Home Page
		And I click on SIGN IN
		And Need an account text is displayed
		When I login with credentials "testing097@gmail.com" and "Login@1234"
		And Error Message is displayed
		Then I login with credentials "testing097@gmail.com" and "Login@123"
		And I am taken to the Account Page
		
		
  
