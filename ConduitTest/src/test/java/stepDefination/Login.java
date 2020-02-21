package stepDefination;

import cucumber.TextContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import managers.FileReaderManager;
import pageObjects.HomePagePO;
import pageObjects.LoginPO;

@SuppressWarnings("deprecation")
public class Login {
	TextContext textContext;
	LoginPO login;
	HomePagePO home;
	Registration reg;
	String uname=FileReaderManager.getInstance().getConfigReader().getTestUserOne();
	String otherUname=FileReaderManager.getInstance().getConfigReader().getTestUserTwo();

	String pwd=FileReaderManager.getInstance().getConfigReader().getPassword();
	String incorrectPwd=FileReaderManager.getInstance().getConfigReader().getIncorrectPassword();

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
	@When("^I login with correct credentials$")
	public void login() throws Throwable {
		home.clickSignIn();
		login.enterCredentials(uname, pwd);
		login.clickOnLogin();
	}
	@And("^I login with other user credentials$")
	public void loginWithOtherUser() throws Throwable {
		home.clickSignIn();
		login.enterCredentials(otherUname, pwd);
		login.clickOnLogin();
	}
	@When("^I login with incorrect credentials$")
	public void loginFailure() throws Throwable {
		home.clickSignIn();
		login.enterCredentials(uname,incorrectPwd);
		Thread.sleep(5000);
		login.clickOnLogin();
	}
	@Then("^Error Message is displayed$")
	public void checkErrorMsg() throws InterruptedException {
		Assert.assertEquals(login.verfiyErrorMessage(), true);

	}

}
