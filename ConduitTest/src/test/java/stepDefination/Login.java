package stepDefination;

import cucumber.TextContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.HomePagePO;
import pageObjects.LoginPO;

@SuppressWarnings("deprecation")
public class Login {
	TextContext textContext;
	LoginPO login;
	HomePagePO home;
	Registration reg;

	public Login(TextContext context) {
		textContext = context;
		login = textContext.getPageObjectManager().getTrueGreenLogin();
		home = textContext.getPageObjectManager().getHomePage();
	}

	@When("^I login with credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login(String email, String pwd) throws Throwable {
		home.clickSignIn();
		login.enterCredentials(email, pwd);
		login.clickOnLogin();
	}

	@Then("^Error Message is displayed$")
	public void checkErrorMsg() throws InterruptedException {
		Assert.assertEquals(login.verfiyErrorMessage(), true);

	}

}
