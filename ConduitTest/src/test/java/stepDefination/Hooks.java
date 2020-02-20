package stepDefination;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import cucumber.TextContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	TextContext testContext;

	public Hooks(TextContext context) {
		testContext = context;
	}

	@After()
	public void AfterSteps(Scenario scenario) {

		if (scenario.isFailed()) {
			scenario.embed(
					((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES),
					"image/png");
		} else {
		}
		testContext.getWebDriverManager().getDriver().close();
		testContext.getWebDriverManager().getDriver().quit();

	}

}
