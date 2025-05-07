package tasks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

@Listeners(ScreenshotListener.class)
public class ExtentReportExample {

    static WebDriver driver;
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
    	//ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReports/ExtentReport.html");
    	// Generate timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "extentReports/ExtentReport_" + timestamp + ".html";

        // Initialize Spark Reporter (use ExtentSparkReporter, not ExtentHtmlReporter for ExtentReports 5.x+)
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
    	sparkReporter.config().setDocumentTitle("Automation Report");
    	sparkReporter.config().setReportName("Test Execution Results");
    	sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Test
    public void failingTest() {
        test = extent.createTest("Failing Test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        test.log(Status.INFO, "Navigated to Google");

        // Intentionally failing
        String title = driver.getTitle();
        assert title.contains("Yahoo") : "Title doesn't match expected!";
        driver.quit();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable());

            // Capture screenshot and attach to report
            String screenshotPath = ScreenshotListener.captureScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}


