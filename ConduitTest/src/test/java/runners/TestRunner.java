package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/functionalTest", glue = { "stepDefination" }, format = { "pretty",
		"html:target/reporting" }, tags = { "@reg" }, monochrome = true)
public class TestRunner {

}
