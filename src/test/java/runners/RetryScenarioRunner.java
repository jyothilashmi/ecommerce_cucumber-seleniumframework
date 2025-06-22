package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "@target/failed_scenarios.txt",
	    glue = {"Learn.com.magento.stepdefinitions","Learn.com.magento.hooks"},
	    plugin = {
	        "pretty",
	        "html:target/rerun-report.html"
	    },
	    monochrome = true
	)
	public class RetryScenarioRunner extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

