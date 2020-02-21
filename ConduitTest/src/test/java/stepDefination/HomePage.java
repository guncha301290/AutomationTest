package stepDefination;

import cucumber.TextContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.HomePagePO;

public class HomePage {
	TextContext textContext;
	HomePagePO home;

	public HomePage(TextContext context) {
		textContext = context;
		home = textContext.getPageObjectManager().getHomePage();
	}

	@Given("^I am on the Conduit Home Page$")
	public void userIsOnHomepage() throws Throwable {
		home.devLogin();
	}
	@And("^Filter Post using Tag$")
	public void filter_Post_using_Tag() throws Throwable {
		home.clickTag();
	}

	@Then("^Result should be shown accordingly$")
	public void result_should_be_shown_accordingly() throws Throwable {
		Assert.assertEquals("On click of filterTags On Home Page, Results are not getting displayed",home.filterPost(), true);

	}
	@And("^I click on Conduit Link$")
	public void clickOnConduitLink(){
		home.clickConduit();
	}
	@Then("^Home Page Banner should be displayed$")
	public void homePage(){
		Assert.assertEquals("Home Page Banner Image is not displayed",home.homePageLogo(),true);
	}
	@And("^Click on Home Link$")
	public void clickOnHome(){
		home.clickOnHome();
	}
	
}
