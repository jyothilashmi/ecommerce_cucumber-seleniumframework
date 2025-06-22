package Learn.com.magneto.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeLocators {
	

	@FindBy(how = How.LINK_TEXT, using = "Sign In")
	protected WebElement linkSignIn;
	
	@FindBy(how=How.XPATH, using = "//li[@class='greet welcome']")
	protected List<WebElement> listWelcome;
	
	@FindBy(how=How.XPATH, using= "(//ul[@class='header links'])[1]")
	protected List<WebElement> listOfWelcome;
	
	@FindBy(how=How.ID, using="search")
	protected WebElement txtSearch;
	
	@FindBy(how=How.ID,using = "search_autocomplete")
	protected WebElement suggestionBox;
	
	@FindBy(how=How.ID,using = "//button[@class='action search']")
	protected WebElement btnSearch;
	
	
	@FindBy(how=How.XPATH,using = "//li//span[@class='qs-option-name']")
	protected List<WebElement> listSuggestion;
	
	@FindBy(how=How.XPATH,using = "(//p[@class='toolbar-amount'])[1]")
	protected WebElement txtAmountOfItems;
	
	@FindBy(how=How.XPATH,using = "(//p[@class='toolbar-amount']//span[3])[1]")
	protected WebElement txtTotalItems;
	
	
	@FindBy(how=How.XPATH,using = "//li[@class='item product product-item']")
	protected List<WebElement> listProductSearch;
	
	@FindBy(how=How.XPATH,using = "//strong[@class='product name product-item-name']")
	protected List<WebElement> listProductNames;
	
	@FindBy(how=How.ID,using = "limiter")
	protected WebElement dropShowLimit;
	
	//@FindBy(how=How.XPATH,using = "//ul[contains(@class, 'pages-items')]//li[contains(@class, 'item') and not(contains(@class, 'pages-item-next'))")
	@FindBy(how=How.XPATH,using ="//ul[@class='items pages-items']//a[@class='page']")
	protected List<WebElement> listTotalProductsInPages;
	
	@FindBy(how=How.XPATH,using = "//a[@class='action  next']")
	protected WebElement btnNextPage;
	
	@FindBy(how=How.XPATH,using = "//a[@class='action  previous']")
	protected WebElement btnPreviousPage;

	//a[@class='action  previous']
	
	
	
	
	

	
	
	
}
