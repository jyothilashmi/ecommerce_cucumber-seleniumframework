package Learn.com.magento.stepdefinitions;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import Learn.com.magento.pages.HomePage;
import Learn.com.magento.pages.LoginPage;
import Learn.com.magneto.base.DriverFactory;
import Learn.com.magneto.base.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home {
	
	private final TestContext testContext;
    private final LoginPage loginPage;
    private HomePage homePage;
    private final WebDriver driver;
    
    Set<String> extractAllLinks=new HashSet<>();
    
    public Home(TestContext context) {
        this.testContext = context;
        this.loginPage = testContext.getLoginPage();
        this.homePage=testContext.getHomePage();
        this.driver = testContext.getDriver();
    }
	@Given("User is in homepage")
	public void user_is_in_homepage() throws InterruptedException {
		homePage.verifyHomePageAfterLogin();
	    }
	@When("User extracts all the links")
	public void user_extracts_all_the_links() {
		extractAllLinks=homePage.extractAllLinks();
	    	    
	}
	@Then("Verify each link returns successful response")
	public void verify_each_link_returns_successful_response() throws IOException {
		homePage.verifyAllHomePageLinks(extractAllLinks);
	    	}
	@When("the user searches for {string}")
	public void the_user_searches_for(String keyword) {
	    homePage.userSearch(keyword);
	    }
	@Then("the search results should display products related to {string}")
	public void the_search_results_should_display_products_related_to(String keyword) {
	    }
	@Then("the search results should include products with names containing {string}")
	public void the_search_results_should_include_products_with_names_containing(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the user applies a price range filter from {string} to {string}")
	public void the_user_applies_a_price_range_filter_from_to(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the results should only include products within the price range")
	public void the_results_should_only_include_products_within_the_price_range() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a message {string} should be displayed")
	public void a_message_should_be_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("sorts the results by {string}")
	public void sorts_the_results_by(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the products should be listed in ascending order of price")
	public void the_products_should_be_listed_in_ascending_order_of_price() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the user filters the results by category {string}")
	public void the_user_filters_the_results_by_category(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the results should only include Gaming Laptops")
	public void the_results_should_only_include_gaming_laptops() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
