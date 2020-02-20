package stepDefination;

import cucumber.TextContext;
import cucumber.api.java.en.And;
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
	
	@And("^I click on SIGN IN$")
	public void clickSignIn() throws Throwable {
		home.clickSignIn();
	}
	@And("^Need an account text is displayed$")
	public void needAndHaveAccount(){
			login.checkNeedAccountLink();
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
