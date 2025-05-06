package JavaPractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import JavaPractice.BaseTest;
import JavaPractice.TestListener;
import JavaPractice.LoginPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void testLoginFailure() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
      // Thread.sleep(10000);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("wrongPass");
        loginPage.clickLogin();

        Assert.assertTrue(false, "Forcing failure to test screenshot on failure");
    }
}
