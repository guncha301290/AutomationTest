package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class RegistrationPO {
	WebDriver driver;
	public String name=null;
	public RegistrationPO(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	private WebElement userName;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement email;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	private WebElement passWord;
	@FindBy(how = How.ID, using = "confirmpassword")
	private WebElement confirmPassword;
	@FindBy(how = How.CSS, using = ".btn")
	private WebElement registerButton;
	@FindBy(how = How.LINK_TEXT, using = "Settings")
	private WebElement successText;
	@FindBy(how = How.CSS, using = "ul.error-messages")
	private WebElement errorMsg;
	@FindBy(how = How.CSS, using = "img.user-pic")
	private WebElement clickOnName;
	@FindBy(how = How.XPATH, using = "//h4/following-sibling::p")
	private WebElement checkbio;
	@FindBy(how = How.LINK_TEXT, using = "Have an account?")
	private WebElement haveAnAccount;
	
	public void clickOnRegisterButton() {
		registerButton.click();
	}
	public String enterDetails(){
		String registerEmail=FileReaderManager.getInstance().getConfigReader().getEmail();
		name=FileReaderManager.getInstance().getConfigReader().getUserName();
		userName.sendKeys(name);
		email.sendKeys(registerEmail);
		passWord.sendKeys("Login@123");
		return registerEmail;
	}
	public void incorrectEmailAndUserName(){
		userName.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaa");
		email.sendKeys("a@a");
		passWord.sendKeys("Login@123");
	}

	public void clickOnRegistrationButton(){
		registerButton.click();
	}
	public boolean verifyRegistration() {

		return successText.isDisplayed();
	}

	public boolean errroMessage() {
		boolean checkMsg = errorMsg.isDisplayed();
		return checkMsg;
	}
	public void clickOnUserName(){
		clickOnName.click();
	}
	public void clickOnHaveAnAccount(){
		haveAnAccount.isDisplayed();
		haveAnAccount.click();
		driver.navigate().refresh();
	}
}
