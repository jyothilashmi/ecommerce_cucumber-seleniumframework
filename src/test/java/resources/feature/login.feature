

Feature: Login feature of magneto ecommerce site
  
  Scenario: Verify the successful login
    Given User is on the login page
    #When user enters valid email and password credentials
    When User logs in with valid credentials
    Then user should land on to home page

    Examples: 
      | email  | password | status  |
      | tttt@gmail.com | abcd@ | success |
     
