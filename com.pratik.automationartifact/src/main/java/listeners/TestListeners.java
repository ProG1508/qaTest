package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import reports.ExtentManager;
import utilities.ScreenShotUtility;

public class TestListeners implements ITestListener {

	private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getReport();
        System.out.println("Test Execution Started");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentManager.getReport().createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL, "Test Failed: " + result.getName());

        // Take Screenshot
        Object testClass = result.getInstance();
        org.openqa.selenium.WebDriver driver = ((BaseTest) testClass).driver;

        String screenshotPath = result.getName();

        ScreenShotUtility.captureScreenShot(driver, screenshotPath);

        test.addScreenCaptureFromPath(
                "screenshots/" + screenshotPath + ".png"
        );	
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReport();
        System.out.println("Test Execution Finished");
    }

	

}
