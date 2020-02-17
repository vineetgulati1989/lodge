package Pages;

import Utils.baseTest;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginPage  {

    private WindowsDriver driver ;

    public static void login(WindowsDriver driver) throws InterruptedException {

        try{
        driver.manage().window().maximize();
        driver.findElementByAccessibilityId("userIDTb").sendKeys("ashish");
        driver.findElementByAccessibilityId("passwordTb").sendKeys("password");
        driver.findElementByAccessibilityId("loginBtn").click();

        Thread.sleep(6000);
        System.out.println("Login successfully");
    }
        catch (Exception e){
        e.printStackTrace();}
    }

    public static void verifyPageTitle(WindowsDriver driver){
        String actualTitle = driver.findElementByAccessibilityId("tenancyName").getText();
        System.out.println(actualTitle);
        Assert.assertEquals("PMC QA Tenancy" ,actualTitle , "Title not matched ");

    }
}
