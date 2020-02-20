package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {
	WebDriver driver;

	public LoginPO(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement email;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	private WebElement passWord;
	@FindBy(how = How.CSS, using = ".btn")
	private WebElement loginButton;
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'email or password')]")
	private WebElement errorMessage;
	@FindBy(how = How.XPATH, using = "//li[@class='breadcrumb-item active']")
	private WebElement validateBreadCrumb;
	@FindBy(how = How.XPATH, using = "//a/span[text()='Account Summary']")
	private WebElement accSummaryText;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='New Password']")
	private WebElement newPassword;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Update Settings')]")
	private WebElement updateSettings;
	@FindBy(how = How.LINK_TEXT, using = "Need an account?")
	private WebElement needAnAccount;
	@FindBy(how = How.LINK_TEXT, using = "Need an account?")
	private WebElement haveAnAccount;
	public void enterCredentials(String name,String pwd) {
		email.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		email.sendKeys(name);
		passWord.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		passWord.sendKeys(pwd);
	}
	public void clickOnLogin() {
		loginButton.click();
	}
	public boolean verifyLogin() throws InterruptedException {
		return accSummaryText.isDisplayed();
	}
	public boolean verfiyErrorMessage() {
		return errorMessage.isDisplayed();
	}
	public void enterNewPassword(){
		newPassword.sendKeys("Login@1234");
	}
	public void updateSettings(){
		updateSettings.click();
	}
	public void checkNeedAccountLink(){
		needAnAccount.isDisplayed();
		needAnAccount.click();
		driver.navigate().back();
	}
	
}
