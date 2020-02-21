@reg
Feature: Follow And Unfollow Other User as a loggedInUser

Background:
    Given I am on the Conduit Home Page
    And I register with random email 
		And I am taken to the Account Page

Scenario: Follow And UnFollow User
		When I click on Global Feed
		And I click on other user post
		And Click follow button
		And Click on Home Link
		Then Feed is showing the post of user I have followed
		And Click on Author Feed
		And Click unfollow button
		And Click on Home Link
		Then Your Feed should not show any post
		

		
		
  
