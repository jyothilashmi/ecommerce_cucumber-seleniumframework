package Learn.com.magento.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Learn.com.magento.utils.ExcelUtil;
import Learn.com.magento.utils.ReportUtil;
import Learn.com.magento.utils.WaitUtil;
import Learn.com.magneto.base.TestContext;
import Learn.com.magneto.locators.LoginLocators;

public class LoginPage extends LoginLocators{
	
	private WebDriver driver;
	private TestContext testContext;
	public LoginPage(WebDriver driver,TestContext testContext)
	{
		this.driver=driver;
		this.testContext = testContext;
		PageFactory.initElements(driver, this);
	}
	
	//Login actions
	public HomePage userLogin(String username, String password) throws IOException
	{
		try
		{
		WaitUtil.waitForElementVisible(driver, txtEmail, 30);
		txtEmail.sendKeys(username);
		txtPassword.sendKeys(password);
		btnSignin.click();
		testContext.getExtentTest().pass("User clicked login");
		return new HomePage(driver,testContext);
		}
		catch(Exception e)
		{
			ReportUtil.logFailureWithScreenshot(driver, testContext.getExtentTest(), e, "Login failed");
	        throw e;

		}
	}
	
	

}
