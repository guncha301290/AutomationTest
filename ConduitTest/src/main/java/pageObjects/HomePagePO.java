package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import managers.FileReaderManager;

public class HomePagePO {
	WebDriver driver;
	List<WebElement> tags=null;
	public HomePagePO(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	private WebElement navLoginButton;
	@FindBy(how = How.LINK_TEXT, using = "Sign up")
	private WebElement navRegisterBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'article-preview') and text() = 'No articles are here... yet.']")
	private WebElement feedPresentOnHomePage;
	public void devLogin() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void scroll() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2500)");
	}

	public void clickSignIn() {
		navLoginButton.click();
	}

	public void clickSignUp() {
		navRegisterBtn.click();
	}

	public void clickOnUserIcon(String username) {

		driver.findElement(By.linkText(username)).click();
	}
	public boolean checkFeedsOnHomePage(){
		return feedPresentOnHomePage.isDisplayed();
	}
	public void visibility() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[@id='LoadingAnimationModal' and @class='open']")));

		} catch (Exception e) {

		}

	}
	public void clickTag(){
		tags=driver.findElements(By.xpath("//div[@class='tag-list']/a"));
		tags.get(0).click();

	}
	public boolean filterPost(){
		String tagName=tags.get(0).getText();
		tags.get(0).click();
		String tagLink=driver.findElement(By.linkText("butt")).getText();
		boolean verify=tagName.contains(tagLink);
		return verify;
	}
}
