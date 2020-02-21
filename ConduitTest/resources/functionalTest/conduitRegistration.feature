@reg
Feature: Registration Application

Scenario: Validation Message in case details not entered

		Given I am on the Conduit Home Page
		When I Click on Sign Up
		And Have an Account Link is displayed
		And Click On Register Button
		Then Error Message should be displayed

Scenario: Validation Message in case incorrect Email Format entered

		Given I am on the Conduit Home Page
		When I Click on Sign Up
		And Enter incorrect details
		Then Error Message should be displayed
		
Scenario: Successfull Registration

		Given I am on the Conduit Home Page
		Then I register with random email
		And I am taken to the Account Page		
  
