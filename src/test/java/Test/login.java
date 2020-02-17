package Test;

import Pages.loginPage;
import Utils.baseTest;
import Utils.commonUtils;
import Utils.simpleReportFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class login extends baseTest{

    loginPage lp = new loginPage();
    baseTest bt = new baseTest();
    commonUtils cu = new commonUtils();

    ExtentReports reporter = simpleReportFactory.getReporter();
    ExtentTest testReporter;



    @Test
    public void loginVerify() throws MalformedURLException, InterruptedException {
        try {
            testReporter = reporter.startTest("lauchBrower");
            testReporter.log(LogStatus.INFO,"lauching app");
            bt.setUp();
            loginPage.login(driver);
            // verify page title after login
            loginPage.verifyPageTitle(driver);
            reporter.endTest(testReporter);
        }
        catch (Exception e){
            e.printStackTrace();
            cu.takeScreenShot(driver,"errorInLogin");
        }

    }

    @AfterClass
    public void afterClass()
    {
        simpleReportFactory.closeReporter();
    }


}
