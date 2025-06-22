#Author: your.email@your.domain.com

Feature: Product search functionality
 As a customer,
  I want to search for products using various keywords and filters,
  So that I can easily find items I am interested in purchasing.
 
Background: 
	Given User is on the login page
    And User logs in with valid credentials
    And User is in homepage
  @smoke @regression
  Scenario: Search by product name
    When the user searches for "Wireless Headphones"
    Then the search results should display products related to "Wireless Headphones"
@regression
Scenario: Search by partial keyword
   	When the user searches for "Head"
    Then the search results should include products with names containing "Head"
@regression    
Scenario: Search with no results
    When the user searches for "asdkjasd12987"
    Then a message "No products found" should be displayed
@regression  	
Scenario: Search and apply category filter
    When the user searches for "Laptop"
    And the user filters the results by category "Gaming"
    Then the results should only include Gaming Laptops
@regression
 Scenario: Search and apply price filter
    When the user searches for "Smartphone"
    And the user applies a price range filter from "$200" to "$500"
    Then the results should only include products within the price range
@regression
  Scenario: Search and sort by price - Low to High
    When the user searches for "Camera"
    And sorts the results by "Price: Low to High"
    Then the products should be listed in ascending order of price
 