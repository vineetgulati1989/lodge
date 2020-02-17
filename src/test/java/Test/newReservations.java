package Test;
import Pages.loginPage;
import Pages.reservationPage;
import Utils.baseTest;
import Utils.commonUtils;
import Utils.simpleReportFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class newReservations extends baseTest {
    commonUtils cu = new commonUtils();
    reservationPage bt = new reservationPage();
    loginPage lg = new loginPage();

    ExtentReports reporter = simpleReportFactory.getReporter();
    ExtentTest testReporter;


    @Test
    public void newRervation() throws MalformedURLException, InterruptedException {
       try {
           testReporter = reporter.startTest("lauchBrower");
           testReporter.log(LogStatus.INFO,"lauching app");

           setUp();
           lg.login(driver);
           bt.newReservation(driver);
           reporter.endTest(testReporter);

       }
       catch( Exception e){
           e.printStackTrace();
           cu.takeScreenShot(driver,"reservationFailed");
       }
       }


    @AfterClass
    public static void TearDown()
    {
        simpleReportFactory.closeReporter();
    }
}
