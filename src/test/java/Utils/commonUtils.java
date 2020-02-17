package Utils;

import io.appium.java_client.windows.WindowsDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class commonUtils {

    private static Logger logger=null;
    static SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
    static Date dNow = new Date();

    public static String date(int dateExtend ,int monthExtend) {
        //static Date dNow = new Date();

         Calendar ct = Calendar.getInstance();
         ct.add(Calendar.MONTH,monthExtend);
         ct.add(Calendar.DATE, dateExtend);
         String inputDate = ft.format(ct.getTime());
         return inputDate;
    }

    public static boolean implictWait(WindowsDriver driver, long time) {

        try {
            driver.manage().timeouts()
                    .implicitlyWait(time, TimeUnit.SECONDS);
            System.out.println("waited for" + time + " sec implicitly");
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean takeScreenShot(WindowsDriver driver,String name){

        try{

            String view = "windowsApp";
            String baseDest="./Screenshots_"+view+"_"+ft.format(dNow)+"/";
            name=baseDest+name;
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(name));
            System.out.println("Screen shot taken");

        }catch(IOException e)
        {
            return false;
        }
        return true;
    }

}

