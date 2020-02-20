package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/functionalTest", glue = { "stepDefination" }, format = { "pretty",
		"html:target/reporting" },

		/* plugin = { "com.cucumber.listener.ExtentCucumberFormatter" }, */tags = { "@reg" }, monochrome = true)
public class TestRunner {


}
