package Learn.com.magneto.base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Learn.com.magento.pages.HomePage;
import Learn.com.magento.pages.LoginPage;

public class TestContext {
	private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ExtentTest extentTest;
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }
    public ExtentTest getExtentTest() {
        return extentTest;
    }

    public void setExtentTest(ExtentTest extentTest) {
        this.extentTest = extentTest;
    }
   }


