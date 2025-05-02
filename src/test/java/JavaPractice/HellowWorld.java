package JavaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HellowWorld {


	 WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        // Set ChromeDriver path if not added to system PATH
	        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	        // Wait for page load
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void loginTest() {
	        // Find username field and enter value
	        WebElement username = driver.findElement(By.name("username"));
	        username.sendKeys("Admin");

	        // Find password field and enter value
	        WebElement password = driver.findElement(By.name("password"));
	        password.sendKeys("admin123");

	        // Find login button and click
	        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
	        loginButton.click();

	        // Wait for dashboard to load
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Assert dashboard is displayed by verifying presence of some element
	        WebElement dashboardHeader = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
	        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard is not displayed - Login might have failed!");
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	
	
}
