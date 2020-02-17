package Pages;

import Utils.commonUtils;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class reservationPage {
    commonUtils cu = new commonUtils();

    @Test
    public void newReservation(WindowsDriver driver) {
        try {
            // open Reservations tab
            driver.findElementByAccessibilityId("TabReservations").click();
            // Making a new reservation
            driver.findElementByAccessibilityId("NewReservationButtom").click();
            // inserting Arrival date
            driver.findElementByAccessibilityId("PART_TextBoxEntryPort").sendKeys(cu.date(2,0));
            // Selecting room type
            driver.findElementByAccessibilityId("roomTypeCb").click();
            driver.findElement(By.name("DBL DBL Deluxe")).click();
            // checking price
            String priceDisplaySubtotal = driver.findElement(By.name("LODGING SUBTOTAL")).getText();
            System.out.println(priceDisplaySubtotal);
            Assert.assertEquals("LODGING SUBTOTAL",priceDisplaySubtotal,"price is not displaying");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//Window/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Edit[5]/Text[1]")).click();
            driver.findElement(By.xpath("//Window/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Edit[5]")).sendKeys("seh");
            driver.findElement(By.xpath("//Window/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Pane[1]/Button[3]")).click();
            driver.findElement(By.xpath("//Window/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Button[12]")).click();
            //Assign Room
            driver.findElementByAccessibilityId("Button_ShowAssignableRooms").click();
            //Room Assigned
            Thread.sleep(3000);
            driver.findElement(By.xpath("//Window/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Pane[1]/Pane[3]")).click();
            //verify that room assigned
            String assignedRoom = driver.findElement(By.xpath("Window/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Pane[1]/Pane[2]/Button[1]/Text[4]")).getText();
            Assert.assertEquals("Unassigned", assignedRoom);
            //click to checkin
            driver.findElement(By.xpath("//Window/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Button[2]")).click();
            Thread.sleep(2000);
            //input govt ID
            driver.findElement(By.xpath("//Window/Window[1]/Edit[1]")).sendKeys("1234");
            //input vehicle plate
            driver.findElement(By.xpath("//Window/Window[1]/Edit[2]")).sendKeys("1323");
            //click on allow checkin without authorization
            driver.findElement(By.xpath("//Window/Window[1]/CheckBox[1]")).click();
            //click checkin
            driver.findElement(By.xpath("//Window/Window[1]/Button[6]")).click();
            Thread.sleep(5000);
            String checkedIn = driver.findElement(By.xpath("Window/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Tab[1]/TabItem[2]/Custom[1]/Text[2]")).getText();
            Assert.assertEquals("CHECKED IN", checkedIn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
