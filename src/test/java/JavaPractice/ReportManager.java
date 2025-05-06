package JavaPractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Initialize ExtentReports instance
    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // System info
            extent.setSystemInfo("Tester", System.getProperty("user.name"));
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("OS Version", System.getProperty("os.version"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extent;
    }

    // Start test and store in ThreadLocal
    public static synchronized void startTest(String testName) {
        ExtentTest extentTest = getExtentReports().createTest(testName);
        test.set(extentTest);
    }

    // Get current test from ThreadLocal
    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    // Flush reports
    public static synchronized void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}



//public class ExtentManager {
//    public static ExtentReports extent;
//
//    public static ExtentReports getExtentReports() {
//        if (extent == null) {
//            ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/ExtentReport.html");
//            extent = new ExtentReports();
//            extent.attachReporter(spark);
//            extent.setSystemInfo("Tester", System.getProperty("user.name")); // Current machine user
//            extent.setSystemInfo("OS", System.getProperty("os.name"));       // OS Name
//            extent.setSystemInfo("OS Version", System.getProperty("os.version")); // OS Version
//            extent.setSystemInfo("Java Version", System.getProperty("java.version")); // Java Version
//
//        }
//        return extent;
//    }
//
//	public static ExtentReports getInstance() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
