package JavaPractice.copy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static ExtentReports extent;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", System.getProperty("user.name")); // Current machine user
            extent.setSystemInfo("OS", System.getProperty("os.name"));       // OS Name
            extent.setSystemInfo("OS Version", System.getProperty("os.version")); // OS Version
            extent.setSystemInfo("Java Version", System.getProperty("java.version")); // Java Version

        }
        return extent;
    }
}
