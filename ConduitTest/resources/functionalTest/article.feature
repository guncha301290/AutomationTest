@reg
Feature: Blog Related scenarios

Background:
    Given I am on the Conduit Home Page
    When I login with credentials "testing097@gmail.com" and "Login@123"
		Then I am taken to the Account Page

Scenario: Write an article 

		When I click on New Post
		And Enter article details
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
		And I post comment by navigating to my article
		Then Comment should be posted
		
Scenario: Delete Comment

		When I click on Global Feed
		And I delete comment by navigating to my article
		Then Comment should be deleted
		
Scenario: Delete Article

		When I click on Global Feed
		And I click on Delete article by navigating to my article
		Then Article Should be deleted from all locations