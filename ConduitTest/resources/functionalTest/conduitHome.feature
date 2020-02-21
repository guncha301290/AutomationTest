@reg
Feature: Home Page related scenarios

Scenario: Validate HomePage as Guest User

		Given I am on the Conduit Home Page
		When I click on Global Feed
		And Filter Post using Tag
		Then Result should be shown accordingly

Scenario: Validate Conduit Link

		Given I am on the Conduit Home Page
		When I click on SIGN IN
		And I click on Conduit Link
		Then Home Page Banner should be displayed