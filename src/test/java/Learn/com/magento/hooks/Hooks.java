package Learn.com.magento.hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Learn.com.magento.pages.HomePage;
import Learn.com.magento.pages.LoginPage;
import Learn.com.magento.utils.CommonActionUtil;
import Learn.com.magento.utils.ReportUtil;
import Learn.com.magneto.base.DriverFactory;
import Learn.com.magneto.base.TestBase;
import Learn.com.magneto.base.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
public class Hooks{
	private final TestContext testContext;
	private final TestBase testBase;
	private static ExtentReports extent;
	public Hooks(TestContext context) {
        this.testContext = context;
        this.testBase = new TestBase();
    }
	@Before
    public void setupDriver(Scenario scenario) throws InterruptedException {
		System.out.println("Scenario name: " +  scenario.getName());
		testBase.setUp();
		//WebDriver driver = DriverFactory.getDriver();
		// Set driver & page objects in TestContext for sharing
		testContext.setDriver(testBase.getDriver());
		testContext.setHomePage(new HomePage(testContext.getDriver(),testContext));
		testContext.setLoginPage(new LoginPage(testContext.getDriver(), testContext));
		
		if (extent == null) {
            extent = ReportUtil.getExtentReports();
        }
        ExtentTest test = extent.createTest(scenario.getName());
        testContext.setExtentTest(test);
    
		
    }
	@AfterStep
    public void afterStep(Scenario scenario) {
        WebDriver driver = testContext.getDriver();
        if (scenario.isFailed()) {
            try {
                String name = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
                String screenshotPath = ReportUtil.captureScreenshot(driver, name);

                // Embed to ExtentReports
                String relativePath = "../screenshots/" + screenshotPath.substring(screenshotPath.lastIndexOf("/") + 1);
                testContext.getExtentTest().fail("Step Failed",
                        MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());

                // Attach to Cucumber report (for console or HTML formatter)
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Step Screenshot");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void teardownDriver(Scenario scenario) {
        if (testContext.getExtentTest() != null && !scenario.isFailed()) {
            testContext.getExtentTest().pass("Scenario passed successfully");
        }

        if (ReportUtil.getExtentReports() != null) {
        	ReportUtil.getExtentReports().flush();
        }

        testBase.tearDown();
    }
	
}
