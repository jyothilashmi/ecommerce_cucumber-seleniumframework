# Ecommerce Cucumber-Selenium Framework

This is a BDD-style test automation framework for an ecommerce website, built using **Selenium WebDriver**, **Cucumber**, **TestNG**, and **Java**.

## Features

- Behavior-Driven Development (BDD) with Cucumber and Gherkin syntax  
- TestNG as the test execution framework  
- Selenium WebDriver for browser automation  
- Data-driven testing using Excel sheets  
- Page Object Model (POM) design pattern for maintainability  
- Configurable environment setup  
- Automatic screenshots on test failures  
- ExtentReports integration for rich HTML test reports  

## Project Structure

├── src/
│ ├── main/
│ │ └── java/ # Page Objects, Utilities (Excel reader, Config reader, etc.)
│ └── test/
│ └── java/ # Step Definitions, TestNG Test Runners
├── features/ # Gherkin feature files
├── reports/ # ExtentReports and other test reports (ignored in .gitignore)
├── screenshots/ # Screenshots captured on test failures (ignored)
├── config/ # Configuration files (e.g., config.properties)
├── resources/ # Test data files (Excel, JSON, etc.)
├── pom.xml # Maven project descriptor
└── README.md # This file

## Prerequisites

- Java JDK 8 or higher  
- Maven installed and configured in your system PATH  
- An IDE like Eclipse or IntelliJ IDEA (recommended)  

## Setup and Running Tests

### 1. Clone the repository

```bash
git clone https://github.com/jyothilashmi/ecommerce_cucumber-seleniumframework.git
cd ecommerce_cucumber-seleniumframework
**### 2. Build the project and download dependencies**
mvn clean install
**### 3. Run tests using Maven and TestNG**
mvn test
**### 4. Run tests with specific Cucumber tags**
If your TestNG runner supports passing tags:
### mvn test -Dcucumber.options="--tags @Login"
### Test Runner

The project uses a **TestNG Cucumber Test Runner** class to execute BDD scenarios with TestNG.

### Sample Runner Class (Java)

```java
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true,
    tags = "@SmokeTest"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // No additional code needed here, TestNG will run scenarios based on these options
}

**### 5. View Test Reports**
ExtentReports HTML reports are generated in the reports/ directory.

Failure screenshots are saved in the screenshots/ directory.

**## Contact**
Jyothi Lakshmi
Email: jyothilakshmisree04@gmail.com


