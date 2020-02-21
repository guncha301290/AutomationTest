package stepDefination;
import cucumber.TextContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import managers.FileReaderManager;
import pageObjects.HomePagePO;
import pageObjects.LoginPO;
import pageObjects.RegistrationPO;

public class Registration {
	TextContext textContext;
	RegistrationPO registration;
	public String email = null;
	LoginPO login;
	HomePagePO home;
	String changePwd=FileReaderManager.getInstance().getConfigReader().getChangePassword();
	public Registration(TextContext context) {
		textContext = context;
		registration = textContext.getPageObjectManager().getRegistration();
		login = textContext.getPageObjectManager().getTrueGreenLogin();
		home = textContext.getPageObjectManager().getHomePage();

	}

	@When("^I register with random email$")
	public void registerUser() {
		home.clickSignUp();
		email = registration.enterDetails();
		registration.clickOnRegisterButton();
	}
	@When("^I Click on Register Link from Nav Link$")
	public void clickRegisterFromNav(){
		home.clickSignUp();

	}
	@When("^Click On Register Button$")
	public void clickOnRegBtn() {
		registration.clickOnRegisterButton();

	}
	@And("^Check Have an Account Link$")
	public void checkHaveAnAccLink(){
		registration.clickOnHaveAnAccount();
	}
	@And("Enter incorrect details$")
	public void incorrectDetails(){
		registration.incorrectEmailAndUserName();
		registration.clickOnRegisterButton();
	}
	@And("^Error Message should be displayed$")
	public void checkErrorMessage() {
		
		registration.errroMessage();
	}

	@Then("^I am taken to the Account Page$")
	public void userIsRegistered() throws Throwable {
		Assert.assertEquals(registration.verifyRegistration(), true);
	}

	@And("^I enter new Correct UserName/email and Password$")
	public void enterNewLoginDetails() throws InterruptedException {
		home.clickSignIn();
		login.enterCredentials(email, changePwd);
		login.clickOnLogin();
	}

}
