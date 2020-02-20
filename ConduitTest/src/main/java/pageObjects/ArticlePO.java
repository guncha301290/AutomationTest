package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import managers.FileReaderManager;

public class ArticlePO {
	WebDriver driver;

	public ArticlePO(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.LINK_TEXT, using = "New Post")
	private WebElement newPost;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Article Title']")
	private WebElement articleTitle;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='What's this article about?']")
	private WebElement articleAbout;

	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Write your article (in markdown)']")
	private WebElement articleBody;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter tags']")
	private WebElement enterTags;
	@FindBy(how = How.CSS, using = ".btn")
	private WebElement publishArticle;
	@FindBy(how = How.LINK_TEXT, using = "Home")
	private WebElement home;
	@FindBy(how = How.LINK_TEXT, using = "Global Feed")
	private WebElement globalFeed;
	@FindBy(how = How.TAG_NAME, using = "h1")
	private WebElement articleText;
	@FindBy(how = How.XPATH, using = "//button/i")
	private WebElement ionHeart;
	@FindBy(how = How.CSS, using = ".btn-primary")
	private WebElement ionHeartText;
	@FindBy(how = How.LINK_TEXT, using = "Favorited Articles")
	private WebElement favArticle;
	@FindBy(how = How.LINK_TEXT, using = "Edit Article")
	private WebElement editArticle;
	@FindBy(how = How.CSS, using = ".btn-outline-danger")
	private WebElement deleteArticle;
	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Write a comment...']")
	private WebElement postComment;
	@FindBy(how = How.XPATH, using = "//button[text()='Post Comment']")
	private WebElement postCommentBtn;
	@FindBy(how = How.CLASS_NAME, using = "card-text")
	private WebElement commentText;
	@FindBy(how = How.CSS, using = "span.mod-options")
	private WebElement deleteComment;
	@FindBy(how = How.XPATH, using = "//div/div[@class='card-block']")
	private WebElement cardBlock;
	public void clickOnNewPost() {
		newPost.click();
	}

	public void enterArticleInfo() throws InterruptedException {
		List<WebElement> formFields = driver.findElements(By.xpath("//form/fieldset/fieldset/input"));
		formFields.get(0).sendKeys("New Post");
		formFields.get(1).sendKeys("Testing");
		formFields.get(2).sendKeys("new");
		driver.findElement(By.xpath("//form/fieldset/fieldset/textarea")).sendKeys("I am testing");
	}

	public void clickPublish() {
		publishArticle.click();
	}

	public boolean checkIfArticleGotPublished(String text) throws InterruptedException {
		Thread.sleep(5000);
		home.click();
		globalFeed.click();
		boolean check=articleText.getText().contains(text);
		return check;
	}
	public void clickOnGlobalFeed(){
		globalFeed.click();
	}
	public void clickOnMyArticle(){
		articleText.click();
	}
	public void clickOnHeart() throws InterruptedException {
		ionHeart.click();

	}

	public String checkHeartColor() throws InterruptedException {
		return ionHeartText.getText();
	}
	public void clickFavArticle(){
		favArticle.click();
	}
	public void editArticle() throws InterruptedException{
		articleText.click();
		editArticle.click();
		List<WebElement> formFields = driver.findElements(By.xpath("//form/fieldset/fieldset/input"));
		Thread.sleep(2000);
		formFields.get(0).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		formFields.get(0).sendKeys("New Post Edit");
		formFields.get(1).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		formFields.get(1).sendKeys("Testing Edit");
		formFields.get(2).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		formFields.get(2).sendKeys("new Edit");
		driver.findElement(By.xpath("//form/fieldset/fieldset/textarea")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//form/fieldset/fieldset/textarea")).sendKeys("I am testing edit");
	}
	public void deleteArticle(){
		deleteArticle.click();
	}
	public void postComment(){
		postComment.sendKeys("Hello Posting Comment");
		postCommentBtn.click();
	}
	public String validateComment(){
		return commentText.getText();
	}
	public void deleteComment() throws InterruptedException{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", deleteComment);
	}
	public boolean cardBlockPresent(){
		return cardBlock.isDisplayed();
	}
	
}
