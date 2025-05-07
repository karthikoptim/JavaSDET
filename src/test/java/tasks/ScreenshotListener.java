package tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

//Listener Class for Screenshot Capture
public class ScreenshotListener implements ITestListener {

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String destPath = "Screenshots/" + screenshotName + "_" + timestamp + ".png";
		File destFile = new File(destPath);

		try {
			destFile.getParentFile().mkdirs();
			Files.copy(srcFile.toPath(), destFile.toPath());
			System.out.println("📸 Screenshot saved at: " + destPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destPath;

	}
}
