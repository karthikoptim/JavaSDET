package JavaPractice;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import JavaPractice.BaseTest;
import JavaPractice.ScreenshotUtil;

//package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//import base.BaseTest;
import JavaPractice.ReportManager;

public class TestListener {
	
	//extends BaseTest implements ITestListener {

    public static ExtentTest test;

//    @Override
//    public void onTestStart(ITestResult result) {
//        test = ReportManager.getExtentReports().createTest(result.getMethod().getMethodName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.log(Status.PASS, "Test Passed");
//    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
//        String testName = result.getName();
//        ReportManager.getTest().fail(result.getThrowable());
//        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, testName);
//        System.out.println("Screenshot saved at: " + screenshotPath);
//        ReportManager.getTest().fail(result.getThrowable());
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//    	ReportManager.getExtentReports().flush();
//    }
}
