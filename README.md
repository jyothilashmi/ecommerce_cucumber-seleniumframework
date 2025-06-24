# Ecommerce Cucumber-Selenium Framework

This is a BDD-style test automation framework for an ecommerce website, built using **Selenium WebDriver**, **Cucumber**, **TestNG**, and **Java**.

---

## ✨ Features

- Behavior-Driven Development (BDD) with Cucumber and Gherkin syntax  
- TestNG as the test execution framework  
- Selenium WebDriver for browser automation  
- Data-driven testing using Excel sheets  
- Page Object Model (POM) design pattern for maintainability  
- Configurable environment setup  
- Automatic screenshots on test failures  
- ExtentReports integration for rich HTML test reports  

---

## 📁 Project Structure

```plaintext
├── src/
│   ├── main/
│   │   └── java/              # Page Objects, Utilities
│   └── test/
│       └── java/              # Step Definitions, Runners
├── features/                  # Gherkin feature files
├── reports/                   # HTML Reports (Extent)
├── screenshots/               # Captured on test failure
├── resources/                 # Excel test data, config files
├── pom.xml                    # Maven project file
└── README.md                  # Project documentation

---

## Prerequisites

- Java JDK 8 or higher  
- Maven installed and configured in your system PATH  
- An IDE like Eclipse or IntelliJ IDEA (recommended)  

## Setup and Running Tests

### 1. Clone the repository

```bash
git clone https://github.com/jyothilashmi/ecommerce_cucumber-seleniumframework.git
cd ecommerce_cucumber-seleniumframework

2. Build the project and download dependencies
bash
Copy
Edit

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


