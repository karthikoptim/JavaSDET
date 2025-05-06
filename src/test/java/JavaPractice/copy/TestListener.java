//package JavaPractice.copy;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import JavaPractice.BaseTest;
//import JavaPractice.ScreenshotUtils;
//
////package utils;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
////import base.BaseTest;
//import JavaPractice.ExtentManager;
//
//public class TestListener extends BaseTest implements ITestListener {
//    public static ExtentTest test;
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        test = ExtentManager.getExtentReports().createTest(result.getMethod().getMethodName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.log(Status.PASS, "Test Passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
//        String testName = result.getName();
//        String screenshotPath = ScreenshotUtils.takeScreenshot(driver, testName);
//        System.out.println("Screenshot saved at: " + screenshotPath);
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        ExtentManager.getExtentReports().flush();
//    }
//}
