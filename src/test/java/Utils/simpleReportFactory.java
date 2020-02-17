package Utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class simpleReportFactory {

    private static ExtentReports reporter;
    // method for report generation
    public static synchronized ExtentReports getReporter() {


        // only one object of reporter
        if (reporter == null) {
            reporter = new ExtentReports(".\\SimpleReport_"+commonUtils.ft.format(commonUtils.dNow)+".html", true, DisplayOrder.NEWEST_FIRST);
        }
        return reporter;
    }

    // closing reporter
    public static synchronized void closeReporter() {
        reporter.flush();
        reporter.close();
    }
}

