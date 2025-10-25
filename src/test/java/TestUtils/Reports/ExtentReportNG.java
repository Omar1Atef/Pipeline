package TestUtils.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    public static ExtentReports extentReports;

    public static ExtentReports getExtentReportsObject() {
        {
            String path = System.getProperty("user.dir") + "/Reports/extentReport.html";
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
            extentSparkReporter.config().setReportName("General Store Automation Report");
            extentSparkReporter.config().setDocumentTitle("Test Report");
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
            extentReports.setSystemInfo("QA", "Special");
            return extentReports;
        }
    }
//    @Test
//    public void TC()
//    {
//        ExtentTest extentTest =extentReports.createTest("TC name");
//        //test steps
//        extentTest.fail("invalid");
//        extentReports.flush();
//    }
}




