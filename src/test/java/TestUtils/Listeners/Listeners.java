package TestUtils.Listeners;

import Utils.Appium.AppiumActions;
import TestUtils.Reports.ExtentReportNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends AppiumActions implements ITestListener {

    AppiumDriver appiumDriver;
    ExtentReports extentReports = ExtentReportNG.getExtentReportsObject();
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        extentTest = extentReports.createTest(result.getName());
//        extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.fail(result.getThrowable());

        //Constructor Won't Work for Listeners because TestNG Creates the Listener, NOT You!
        //and this step only ( That Reflection Code) ONLY Works in Listeners  (result is an ITestResult object - ITestResult result is ONLY available in TestNG Listener methods) (Regular classes don't have access to result)
        try {
            appiumDriver = (AppiumDriver) result.getTestClass().getRealClass().getField("androidDriver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            // Try to get androidDriver first
//            appiumDriver = (AppiumDriver) result.getTestClass()
//                    .getRealClass()
//                    .getField("androidDriver")
//                    .get(result.getInstance());
//        } catch (Exception e1) {
//            try {
//                // If androidDriver not found, try iosDriver
//                appiumDriver = (AppiumDriver) result.getTestClass()
//                        .getRealClass()
//                        .getField("iosDriver")
//                        .get(result.getInstance());
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }

        // if i want to attach screenshot in my framework and in report both
        try {
            extentTest.addScreenCaptureFromPath(getScreenShotPath(result.getName(), appiumDriver),result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // if i want to attach screenshot only in my framework only without using report
//        try {
//            getScreenShotPath(result.getName(), appiumDriver);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

}