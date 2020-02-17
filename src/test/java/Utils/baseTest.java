package Utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;

public class baseTest {

   protected StringBuffer verificationErrors = new StringBuffer();
   protected static WindowsDriver driver = null;
   private static String appKey = "C:\\Program Files\\HOLMS\\Integrate LodgeIC 2\\LodgeIC2.exe";

   public void setUp() throws InterruptedException, MalformedURLException {
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("app", appKey);
       capabilities.setCapability("deviceName" , "WindowsPC");
       Thread.sleep(4000);
       driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
       Thread.sleep(4000);
   }


    @AfterClass
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }

    }
}
