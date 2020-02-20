package stepDefination;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.TextContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
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
