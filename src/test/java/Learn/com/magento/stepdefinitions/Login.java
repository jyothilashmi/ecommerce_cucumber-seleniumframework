package Learn.com.magento.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Learn.com.magento.pages.HomePage;
import Learn.com.magento.pages.LoginPage;
import Learn.com.magento.utils.CommonActionUtil;
import Learn.com.magento.utils.ExcelUtil;
import Learn.com.magento.utils.LoggerUtil;
import Learn.com.magneto.base.DriverFactory;
import Learn.com.magneto.base.TestBase;
import Learn.com.magneto.base.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	private final TestContext testContext;
    private final LoginPage loginPage;
    private HomePage homePage;
    private final WebDriver driver;
    
    public Login(TestContext context) {
        this.testContext = context;
        this.loginPage = testContext.getLoginPage();
        this.homePage=testContext.getHomePage();
        this.driver = testContext.getDriver();
    }

    @Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    
		homePage.clickOnSignIn();
	}
	@When("user enters valid email and password credentials")
	public void user_enters_valid_email_and_password_credentials() throws Exception {
		//homePage=loginPage.userLogin(ExcelUtil.getData("Username", "TC001"),ExcelUtil.getData("Password", "TC001"));
		String username=CommonActionUtil.decrypt(ExcelUtil.getDataCommon("Username", "TC001","Login"));
		String password=CommonActionUtil.decrypt(ExcelUtil.getDataCommon("Password", "TC001","Login"));
		//homePage=loginPage.userLogin(ExcelUtil.getDataCommon("Username", "TC001","Login"),ExcelUtil.getDataCommon("Password", "TC001","Login"));
		homePage=loginPage.userLogin(username,password);
		
	    
	}
	@Then("user should land on to home page")
	public void user_should_land_on_to_home_page() throws InterruptedException {
	    homePage.verifyTitle("Home Page", "softwaretestingboard.com/");
			    
	}



}
