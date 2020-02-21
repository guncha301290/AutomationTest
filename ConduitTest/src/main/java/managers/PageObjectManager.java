package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.ArticlePO;
import pageObjects.HomePagePO;
import pageObjects.LoginPO;
import pageObjects.RegistrationPO;
import pageObjects.AccountPO;

public class PageObjectManager {

	private WebDriver driver;
	private HomePagePO home;
	private LoginPO trueGreenLogin;
	private RegistrationPO registration;
	private AccountPO settings;
	private ArticlePO article;
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePagePO getHomePage() {
		return (home == null) ? home = new HomePagePO(driver) : home;

	}
	public LoginPO getTrueGreenLogin() {
		return (trueGreenLogin == null) ? trueGreenLogin = new LoginPO(driver) : trueGreenLogin;

	}

	public RegistrationPO getRegistration(){
		return (registration == null) ? registration = new RegistrationPO(driver) : registration;

	}

	public AccountPO getSettings(){
		return (settings == null) ? settings = new AccountPO(driver) : settings;

	}
	public ArticlePO getArticle(){
		return (article == null) ? article = new ArticlePO(driver) : article;

	}
	
}
