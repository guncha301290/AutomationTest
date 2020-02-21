package stepDefination;

import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import cucumber.TextContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import managers.FileReaderManager;
import pageObjects.ArticlePO;
import pageObjects.HomePagePO;
import pageObjects.LoginPO;
import pageObjects.RegistrationPO;
import pageObjects.AccountPO;
import static org.junit.Assert.*;

@SuppressWarnings("deprecation")
public class Article {
	TextContext textContext;
	LoginPO login;
	HomePagePO home;
	AccountPO settings;
	RegistrationPO reg;
	ArticlePO article;

	public Article(TextContext context) {
		textContext = context;
		login = textContext.getPageObjectManager().getTrueGreenLogin();
		home = textContext.getPageObjectManager().getHomePage();
		settings = textContext.getPageObjectManager().getSettings();
		reg = textContext.getPageObjectManager().getRegistration();
		article = textContext.getPageObjectManager().getArticle();
	}

	@When("^I click on New Post$")
	public void clickNewPost() throws Throwable {
		article.clickOnNewPost();
	}

	@And("^Enter article details$")
	public void enter_article_details() throws Throwable {
		article.enterArticleInfo();
		article.clickPublish();
	}

	@When("^Click on Publish Article$")
	public void click_on_Publish_Article() throws Throwable {
		article.clickPublish();
	}

	@Then("^Article should be present/posted$")
	public void article_should_be_published() throws Throwable {
		boolean check = article.checkIfArticleGotPublished("New Post");
		Assert.assertEquals(check, true);

	}

	@And("^I click on like icon$")
	public void i_click_on_favourite_icon() throws Throwable {
		article.clickOnHeart();
	}

	@And("^like count should increase$")
	public void icon_should_turn_green_and_show_count() throws Throwable {
		Assert.assertEquals(article.checkHeartColor().contains("1"), true);

	}

	@When("^User clicks on Edit Article$")
	public void editArticle() throws InterruptedException {
		article.editArticle();
		article.clickPublish();
	}

	@Then("^Article should be updated$")
	public void verifyEdit() throws InterruptedException {

		boolean check = article.checkIfArticleGotPublished(FileReaderManager.getInstance().getConfigReader().getArticleEditTitle());
		Assert.assertEquals(check, true);

	}

	@When("^I click on Global Feed$")
	public void i_click_on_Global_Feed() throws Throwable {
		article.clickOnGlobalFeed();
	}
	
	@And("^I click on Delete article by navigating to my article$")
	public void i_click_on_Delete_article() throws Throwable {
		article.clickOnMyArticle();
		article.deleteArticle();
	}

	@And("^I post comment by navigating to my article$")
	public void postComment() throws Throwable {
		//article.clickOnMyArticle();
		article.postComment();
	}

	@Then("^Comment should be posted$")
	public void checkCommentGotPosted() throws Throwable {

		Assert.assertEquals(article.validateComment().contains(FileReaderManager.getInstance().getConfigReader().getPostComment()), true);

	}

	@And("^I delete comment by navigating to my article$")
	public void deleteComment() throws Throwable {
		article.clickOnMyArticle();
		article.deleteComment();
	}

	@Then("^Comment should be deleted$")
	public void validateComment() throws Throwable {
		Assert.assertEquals(article.cardBlockPresent(), false);
	}
	@And("^I click on other user post$")
	public void clickOtherUserPost(){
		article.clickOtherUserPost();
	}
	@And("^Check Feed$")
	public void checkYourFeed(){
		Assert.assertEquals(article.checkYourFeed(),true);
	}
	@And("^Click follow button$")
	public void clickFollowBtn() throws InterruptedException{
		article.clickFollowButton();
	}
	@And("^UnFollow Button shouldnt appear$")
	public void checkUnFollowButton(){
		Assert.assertEquals(article.checkIfUserIsAbleToFollow(),true);
	}
	@And("^Click unfollow button$")
	public void clickUnFollowBtn() throws InterruptedException{
		Thread.sleep(3000);
		article.clickUnFollowButton();

	}
	@And("^Click on Author Feeed$")
	public void clickOnAuthorFeed(){
		article.clickOnAuthorFeed();

	}
	@And("^Check Feed should not have any post$")
	public void checkNoFeed() throws InterruptedException{
		Assert.assertEquals(article.checkNoArticleText().contains("No articles are here... yet."),true);

	}
	@And("^User clicks on Read More Link$")
	public void clicReadMOre(){
		article.readMoreLink();
	}
}
