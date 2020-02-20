@reg
Feature: Check Follow And Unfollow  User as a Guest User. It should not allow guest user to follow other user

Background:
    Given I am on the Conduit Home Page

Scenario: Follow And UnFollow User
		And I click on other user post
		And Click follow button
		Then UnFollow Button shouldnt appear
		

		
		
  
