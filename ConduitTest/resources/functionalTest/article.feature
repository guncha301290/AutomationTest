@reg
Feature: Blog Related scenarios

Background:
    Given I am on the Conduit Home Page
    When I login with correct credentials
		Then I am taken to the Account Page

Scenario: Write an article 

		When I click on New Post
		And Enter article details
		Then Article should be present/posted
		And Click on Log Out Button and relogin with new credentials
		And I login with other user credentials
		And I click on Global Feed
		Then Article should be present/posted
	
				
Scenario: Edit an article 
		When User clicks on Edit Article
		Then Article should be updated
		
Scenario: Hit Like 
		When I click on Global Feed
		And I click on like icon
		And I click on Favourite Article Tab on my Account
		Then Article should be present/posted
		And like count should increase


Scenario: Post Comment

		When I click on Global Feed
		And User clicks on Read More Link
		And I post comment by navigating to my article
		Then Comment should be posted
		
Scenario: Delete Comment

		When I click on Global Feed
		And I delete comment by navigating to my article
		Then Comment should be deleted
		
Scenario: Delete Article

		When I click on Global Feed
		And I click on Delete article by navigating to my article
		Then Your Feed should not show any post