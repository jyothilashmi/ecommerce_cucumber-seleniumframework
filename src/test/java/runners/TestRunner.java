package runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(
		features="src/test/java/resources/feature",
		glue={"Learn.com.magento.stepdefinitions","Learn.com.magento.hooks"},
		plugin={"pretty","html:target/cucumber-report.html",
				"json:target/cucumber-report.json",
				"testng:target/testng-cucumber.xml",
				"rerun:target/failed_scenarios.txt"},
				monochrome = true,
				dryRun=true
				
				)
public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
