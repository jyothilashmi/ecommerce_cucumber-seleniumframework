package Learn.com.magento.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Learn.com.magento.utils.LoggerUtil;
import Learn.com.magento.utils.WaitUtil;
import Learn.com.magneto.base.TestContext;
import Learn.com.magneto.locators.HomeLocators;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;

public class HomePage extends HomeLocators{

	private WebDriver driver;
	private TestContext testContext;
	
	public HomePage(WebDriver driver,TestContext testContext )
	{
		
		this.driver=driver;
		this.testContext=testContext;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyTitle(String expectedTitle,String url) throws InterruptedException
	{
		WaitUtil.waitForPageLoad(driver,50);
		WaitUtil.waitForLandingPage(driver,url,20);
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(),expectedTitle,testContext.getExtentTest().pass("Landed on to homepage successfully.").toString());		
	}
	public void clickOnSignIn()
	{
		WaitUtil.waitForElementVisible(driver, linkSignIn,30);
		linkSignIn.click();
		LoggerUtil.getInfo("Landed to Login Page.");
	}
	public void verifyHomePageAfterLogin() throws InterruptedException {
	    	    Thread.sleep(4000); // 

	    boolean bannerFound = false;

	    for (WebElement getWelcomeBanner : listOfWelcome) {
	        String banner = getWelcomeBanner.getText();
	        LoggerUtil.getInfo("Welcome banner text: " + banner);

	        if (banner.equals("Welcome, Jyo Lak!")) {
	            LoggerUtil.getInfo("Expected welcome banner found.");
	            testContext.getExtentTest().pass("Expected welcome banner 'Welcome, Jyo Lak!' was  found.").toString();
	            bannerFound = true;
	            break; 	        }
	    }

	    // Final assertion
	    //Assert.assertTrue(bannerFound, testContext.getExtentTest().fail("Expected welcome banner 'Welcome, Jyo Lak!' was not found.").toString());
	}
public Set<String> extractAllLinks()
	{
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		Set<String> uniqueLinks=new HashSet<>();
		for(WebElement li:links)
		{
			String url=li.getAttribute("href");
			if(url!=null && !url.isEmpty())
			{
				uniqueLinks.add(url);
			}
		}
		return uniqueLinks;
	}
	public void verifyAllHomePageLinks(Set<String>links) throws IOException
	{	
		for(String getLink:links)
		{
		URL url=new URL(getLink);
		HttpURLConnection  httpConnect=(HttpURLConnection)url.openConnection();
		httpConnect.setConnectTimeout(1000);
		httpConnect.connect();
		
		int statusCode = httpConnect.getResponseCode();
        String message = httpConnect.getResponseMessage();
        if (statusCode >= 400) {
            System.out.println("❌ BROKEN: " + getLink + " --> " + statusCode + " " + message);
            testContext.getExtentTest().fail("❌ BROKEN: " + getLink + " --> " + statusCode + " " + message);
        } else {
        	testContext.getExtentTest().pass("✅ OK: " + getLink + " --> " + statusCode);
        }
        
		}
		
	}
	public void userSearch(String keyword)
	{
		txtSearch.sendKeys(keyword);
		if(suggestionBox.isDisplayed())
		{
			testContext.getExtentTest().info("Suggestion box is displayed");
		}
		else
		{
			testContext.getExtentTest().info("Suggestion box isn't displayed");
		}
		btnSearch.click();
	}
	public void productSearchDisplay(String keyword,int productLimitPerPage)
	{
		
		Select setProductsPerPage=new Select(dropShowLimit);
		setProductsPerPage.selectByVisibleText(String.valueOf(productLimitPerPage));
		
		String numberOfItems=txtAmountOfItems.getText();
		if(numberOfItems.contains("of"))
		{
			int totalNumberOfItems=Integer.valueOf(txtTotalItems.getDomProperty("value"));
			testContext.getExtentTest().info("Number of items listed for the search :: "+keyword);
			
		}
		
	}
}
