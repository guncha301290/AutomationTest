package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class AccountPO {
	WebDriver driver;

	public AccountPO(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Update Settings')]")
	private WebElement updateSettings;	
	@FindBy(how = How.CSS, using = ".btn-outline-danger")
	private WebElement logout;	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='New Password']")
	private WebElement newPassword;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='URL of profile picture']")
	private WebElement photo;
	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Short bio about you']")
	private WebElement bioText;
	@FindBy(how = How.CSS, using = "img.user-pic")
	private WebElement clickOnName;
	@FindBy(how = How.XPATH, using = "//h4/following-sibling::p")
	private WebElement checkbio;
	@FindBy(how = How.TAG_NAME, using = "img")
	private WebElement checkImage;
	@FindBy(how = How.LINK_TEXT, using = "Edit Profile Settings")
	private WebElement editProfile;
	@FindBy(how = How.LINK_TEXT, using = "Favorited Articles")
	private WebElement favArticle;
	public void updateSettings(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", updateSettings);
	}
	public void clickOnLogout(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", logout);
		}
	public void clickOnSettings(){
		driver.navigate().refresh();
		WebElement settings=driver.findElement(By.linkText("Settings"));
		settings.click();
	}
	public void enterNewPass(){
		newPassword.sendKeys("Login@1234");
	}
	public void enterBioAndPicture(){
		bioText.sendKeys("I am testing");
		photo.sendKeys("https://homepages.cae.wisc.edu/~ece533/images/cat.png");

	}
	public void clickFavArticle(){
		favArticle.click();
	}
	public void clickOnName(){
		
		driver.findElements(By.tagName("li")).get(3).click();
		driver.navigate().refresh();
	}
	public String checkMyAcc(){
		return checkbio.getText();
	}
	public void addPicture(){
		photo.sendKeys("https://homepages.cae.wisc.edu/~ece533/images/cat.png");
	}
	public boolean verifyImage() throws InterruptedException{
		Thread.sleep(2000);
		boolean check=checkImage.getAttribute("src").contains("cat.png");
		System.out.println(checkImage.getAttribute("src"));
		System.out.println(check);
		return check;
	}
	public void editProfileSettings(){
		editProfile.click();
	}
	public void removePicture(){
		photo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}
}
