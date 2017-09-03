package runnerPackage;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
		format={"json:target/cucumber.json","html:target/site/cucumber-pretty"}
        ,features = { "src/test/java/features" }
        ,glue = { "stepDefinition" }
        )

public class TestRunner extends AbstractTestNGCucumberTests {

}