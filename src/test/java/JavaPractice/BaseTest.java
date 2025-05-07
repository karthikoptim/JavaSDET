package JavaPractice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;
import JavaPractice.ReportManager;
import JavaPractice.ScreenshotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.UUID;

//public class BaseTest {
//
//    protected WebDriver driver;
//
//    @BeforeMethod
//    public void setUp(Method method) throws IOException {
//        // Initialize WebDriver (ChromeDriver here — replace if needed)
//    	
//    	WebDriverManager.chromedriver().setup();
//
//        Path tempProfile = Files.createTempDirectory("profile_" + UUID.randomUUID());
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--user-data-dir=" + tempProfile.toString());
//        
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        // Start ExtentTest for this method
//        ReportManager.startTest(method.getName());
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        // If test failed, capture screenshot and attach to report
//        if (result.getStatus() == ITestResult.FAILURE) {
//            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
//            ReportManager.getTest().log(Status.FAIL, "Test Failed — screenshot attached.")
//                    .addScreenCaptureFromPath(screenshotPath);
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            ReportManager.getTest().log(Status.PASS, "Test Passed");
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            ReportManager.getTest().log(Status.SKIP, "Test Skipped");
//        }
//
//        // Quit browser after each test
//        if (driver != null) {
//            driver.quit();
//        }
//
//        // Flush report
//        ReportManager.flushReports();
//    }
//}




//public class BaseTest {
//    public static WebDriver driver;
//
////    @BeforeMethod
////    public void setUp() {
////        driver = new ChromeDriver();
////        driver.manage().window().maximize();
////    }
////
////    @AfterMethod
////    public void tearDown() {
////        if (driver != null) {
////            driver.quit();
////        }
////    }
//    
//    
//}
