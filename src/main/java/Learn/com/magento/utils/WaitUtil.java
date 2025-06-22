package Learn.com.magento.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class WaitUtil {
	
	
	
	public static void waitForElementVisible(WebDriver driver, WebElement element, int time)
	{
		new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForPageLoad(WebDriver driver,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        });	
	}
	public static void waitForElements(WebDriver driver, List<WebElement> element, int time)
	{
		new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOfAllElements(element));
	}
	public static void waitForLandingPage(WebDriver driver, String url, int time)
	{
		new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.urlContains(url));
	}

}
