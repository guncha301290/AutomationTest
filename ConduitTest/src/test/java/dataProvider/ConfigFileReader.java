package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "config//configuration.properties";
	private String URL=System.getProperty("url");
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	public String getApplicationUrl() {
		String url = URL;
		if (url != null)
			return url;
		else{
			String newurl = properties.getProperty("url");
			return newurl;
		}
		
	}
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer"))
			return DriverType.IE;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environmentName.equals("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}
	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}
	public String getUserName(){
		String userName="conduit"+ new Date().getDate()+new Date().getHours()+new Date().getMinutes()+ new Date().getSeconds();
		return userName;
	}
	public String getEmail(){
		String email="conduit"+new Date().getDate()+new Date().getHours()+new Date().getMinutes()+ new Date().getSeconds()+"@test.com";
		return email;
	}
	public String getTestUserOne(){
		String testUserOne=properties.getProperty("loggedInUser1");
		return testUserOne;
	}
	public String getTestUserTwo(){
		String testUserTwo=properties.getProperty("loggedInUser2");
		return testUserTwo;
	}
	public String getPassword(){
		String password=properties.getProperty("password");
		return password;
	}
	public String getIncorrectPassword(){
		String incorrectPassword=properties.getProperty("incorrectPass");
		return incorrectPassword;
	}
	public String getChangePassword(){
		String changePassword=properties.getProperty("changePass");
		return changePassword;
	}
	public String getIncorrectUserName(){
		String incorrectUserName=properties.getProperty("incorrectUserName");
		return incorrectUserName;
	}
	public String getIncorrectEmail(){
		String incorrectEmail=properties.getProperty("incorrectEmail");
		return incorrectEmail;
	}
	public String getBio(){
		String bio=properties.getProperty("bioText");
		return bio;
	}
	public String getImageLink(){
		String imageLink=properties.getProperty("imageLink");
		return imageLink;
	}
	public String getImageSrc(){
		String src=properties.getProperty("src");
		return src;
	}
	public String getArticleTitle(){
		String bioText=properties.getProperty("articleTitle");
		return bioText;
	}
	public String getArticleDesc(){
		String bioText=properties.getProperty("articleDes");
		return bioText;
	}
	public String getArticleBody(){
		String bioText=properties.getProperty("bioText");
		return bioText;
	}
	public String getArticleTag(){
		String bioText=properties.getProperty("tag");
		return bioText;
	}
	public String getArticleEditTitle(){
		String bioText=properties.getProperty("editArticleTitle");
		return bioText;
	}
	public String getArticleEditDesc(){
		String bioText=properties.getProperty("editArticleDesc");
		return bioText;
	}
	public String getArticleEditBody(){
		String bioText=properties.getProperty("editArticleBody");
		return bioText;
	}
	public String getArticleEditTag(){
		String bioText=properties.getProperty("editArticleTag");
		return bioText;
	}
	public String getPostComment(){
		String postComment=properties.getProperty("postComment");
		return postComment;
	}
}
