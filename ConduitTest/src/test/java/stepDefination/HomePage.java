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
		Assert.assertEquals(home.filterPost(), true);

	}
	@Then("^I should be able to see my published articles$")
	public void checkMyFeedOnHomePage(){
		Assert.assertEquals(home.checkFeedsOnHomePage(),false);
	}
}
