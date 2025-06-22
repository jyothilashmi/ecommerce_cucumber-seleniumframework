package Learn.com.magento.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil {
	private static ExtentReports extent;
	private ReportUtil()
	{
		
	}
	public static ExtentReports getExtentReports() {
        if (extent == null) {
            
            extent = new ExtentReports();
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            
        
            sparkReporter.config().setDocumentTitle("Magento ecommerce website automation test report");
            sparkReporter.config().setReportName("Automation Test Results - Magento");
            sparkReporter.config().setEncoding("utf-8");
            sparkReporter.config().setTimelineEnabled(true);
            sparkReporter.config().setTheme(Theme.DARK);
            extent.attachReporter(sparkReporter);
            
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            extent.setSystemInfo("Report at::", dateTime);


        }
        return extent;
        }
	public static String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
	public static void logFailureWithScreenshot(WebDriver driver, ExtentTest test, Exception e, String stepDescription) {
        try {
            String screenshotPath = captureScreenshot(driver, "Failure_" + stepDescription.replaceAll(" ", "_"));
            test.fail(stepDescription + " - Exception: " + e.getMessage(),
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            test.info("Stack Trace:\n" + getStackTrace(e));
        } catch (Exception ex) {
            test.fail("Error while capturing screenshot: " + ex.getMessage());
        }
    }
	public static String captureScreenshot(WebDriver driver,String screenshotName)
    {
	String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String finalName = screenshotName + "_" + timestamp + ".png";
    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String path = System.getProperty("user.dir") + "/screenshots/" + finalName;

    try {
        Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots"));
        Files.copy(src.toPath(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return path;}
		
    }


