@reg
Feature: Home Page related scenarios

Scenario: Validate HomePage as Guest User

		Given I am on the Conduit Home Page
		When I click on Global Feed
		And Filter Post using Tag
		Then Result should be shown accordingly

Scenario: Validate HomePage as LoggedIn User

		Given I am on the Conduit Home Page
		When I login with credentials "testing0977@gmail.com" and "Login@123"
		Then I should be able to see my published articles

