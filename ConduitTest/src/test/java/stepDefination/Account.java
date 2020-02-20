package stepDefination;

import org.openqa.selenium.WebDriver;
import cucumber.TextContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.HomePagePO;
import pageObjects.LoginPO;
import pageObjects.RegistrationPO;
import pageObjects.AccountPO;

@SuppressWarnings("deprecation")
public class Account {
	TextContext textContext;
	LoginPO login;
	HomePagePO home;
	AccountPO settings;
	RegistrationPO reg;
	WebDriver driver;

	public Account(TextContext context) {
		textContext = context;
		login = textContext.getPageObjectManager().getTrueGreenLogin();
		home = textContext.getPageObjectManager().getHomePage();
		settings = textContext.getPageObjectManager().getSettings();
		reg = textContext.getPageObjectManager().getRegistration();
		driver = textContext.getWebDriverManager().getDriver();
	}

	@And("^Click on Log Out Button and relogin with new credentials$")
	public void clickOnLogoutBtn() {
		settings.clickOnSettings();
		settings.clickOnLogout();

	}

	@When("^Enter New Password$")
	public void enterNewPwd() {
		settings.clickOnSettings();
		settings.enterNewPass();
		settings.updateSettings();

	}

	@When("^Enter The Bio and image$")
	public void enterBioAndImage() {
		settings.clickOnSettings();
		settings.enterBioAndPicture();
		settings.updateSettings();
		
	}

	@Then("^My Account page shows my bio details and image$")
	public void myAccount() throws InterruptedException {
		settings.clickOnName();
		Assert.assertEquals(settings.checkMyAcc().contains("I am testing"), true);
		Assert.assertEquals(settings.verifyImage(), true);

	}

	@And("^Remove Image$")
	public void removePicture() throws InterruptedException {
		settings.editProfileSettings();
		settings.removePicture();
		Thread.sleep(7000);
		settings.updateSettings();
	}
	@And("^I click on Favourite Article Tab on my Account$")
	public void favArticleTab(){
		settings.clickOnName();
		settings.clickFavArticle();
	}

}
