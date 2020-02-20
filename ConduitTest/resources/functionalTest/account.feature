@reg
Feature: To Test Account related stories

Background:
    Given I am on the Conduit Home Page
    And I register with random email 
		And I am taken to the Account Page

Scenario: Check ChangePassword
		When Enter New Password
		And Click on Log Out Button and relogin with new credentials
		And I enter new Correct UserName/email and Password
		Then I am taken to the Account Page

Scenario: Check Bio And Add Image Settings
		When Enter The Bio and image
		Then My Account page shows my bio details and image
		And Remove Image
		
		
  
