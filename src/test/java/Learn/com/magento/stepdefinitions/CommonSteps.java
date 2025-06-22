package Learn.com.magento.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Learn.com.magento.pages.HomePage;
import Learn.com.magento.pages.LoginPage;
import Learn.com.magento.utils.CommonActionUtil;
import Learn.com.magento.utils.ExcelUtil;
import Learn.com.magneto.base.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonSteps {
	
	private final TestContext testContext;
    private final LoginPage loginPage;
    private HomePage homePage;
    private final WebDriver driver;
    
    public CommonSteps(TestContext context) {
        this.testContext = context;
        this.loginPage = testContext.getLoginPage();
        this.homePage=testContext.getHomePage();
        this.driver = testContext.getDriver();
    }
	@And("User logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() throws Exception {
		String username=CommonActionUtil.decrypt(ExcelUtil.getDataCommon("Username", "TC001","Login"));
		String password=CommonActionUtil.decrypt(ExcelUtil.getDataCommon("Password", "TC001","Login"));
		//homePage=loginPage.userLogin(ExcelUtil.getDataCommon("Username", "TC001","Login"),ExcelUtil.getDataCommon("Password", "TC001","Login"));
		homePage=loginPage.userLogin(username,password);
		
	
	}


}
