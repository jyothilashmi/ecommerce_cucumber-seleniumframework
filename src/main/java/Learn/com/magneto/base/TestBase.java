package Learn.com.magneto.base;

import org.openqa.selenium.WebDriver;

import Learn.com.magento.utils.ConfigUtil;
import Learn.com.magento.utils.LoggerUtil;
import org.testng.annotations.*;

public class TestBase {

	protected WebDriver driver;
	
	//@BeforeSuite(alwaysRun=true)
	//@Parameters("browser")
    //@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	{
		String browser=ConfigUtil.getProperty("browser");
		driver = DriverFactory.initDriver(browser);
		System.out.println("2");
		//DriverFactory.setDriver(driver);
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
		driver.get(ConfigUtil.getProperty("app.baseUrl"));
		LoggerUtil.getInfo("Browser launched and navigated to the application: " + ConfigUtil.getProperty("app.baseUrl"));
	}
	public WebDriver getDriver() {
        return driver;
    }
	//@AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
        	DriverFactory.quitDriver();
            LoggerUtil.getInfo("Browser session ended.");
        }
    }
    

	
}
