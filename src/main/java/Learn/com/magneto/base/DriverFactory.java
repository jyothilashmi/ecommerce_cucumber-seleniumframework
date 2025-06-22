package Learn.com.magneto.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

	public static WebDriver initDriver(String browser) 
	{
		WebDriver driverInstance;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
	        //options.addArguments("start-maximized");  // Open in maximized mode
	        options.addArguments("--disable-blink-features=AutomationControlled");  // Help reduce bot detection
	        options.addArguments("--incognito");
            driverInstance=new ChromeDriver(options);
	        		
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driverInstance=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driverInstance=new EdgeDriver();
		}
		else
		{
			throw new IllegalArgumentException("Unsupported browser: " + browser);

		}
		setDriver(driverInstance);
		// Maximize browser window
		System.out.println("3");
        getDriver().manage().window().maximize();
        return getDriver();
    
	}
	// Returns the current WebDriver instance
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    // Quits the driver and removes the thread-local reference
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
