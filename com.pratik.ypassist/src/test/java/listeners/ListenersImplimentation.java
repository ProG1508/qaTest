package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.pratik.ypassist.basepage.DriverSetup;
import com.pratik.ypassist.com.utilities.ExtentReportManager;
import com.pratik.ypassist.com.utilities.ScreenshotUtil;

public class ListenersImplimentation implements ITestListener {

    private static final Logger logging =
            LogManager.getLogger(ListenersImplimentation.class);

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getName();

        ExtentReportManager.createTest(testName);

        ExtentReportManager.getTest().log(
                Status.INFO, "Test Started: " + testName);

        logging.info("Test Started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logging.info("Test Successful: " + result.getName());

        ExtentReportManager.getTest().log(
                Status.PASS, "Test Passed: " + result.getName());

        takeScreenshot(result, true);

        ExtentReportManager.removeTest();

        logging.info("============================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logging.error("Test Failed: " + result.getName());

        ExtentReportManager.getTest().log(
                Status.FAIL, "Test Failed: " + result.getName());

        if (result.getThrowable() != null) {
            ExtentReportManager.getTest().fail(
                    result.getThrowable());
        }

        takeScreenshot(result, false);

        ExtentReportManager.removeTest();

        logging.info("============================================");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logging.info("Test Skipped: " + result.getName());

        ExtentReportManager.getTest().log(
                Status.SKIP, "Test Skipped: " + result.getName());

        if (result.getThrowable() != null) {
            ExtentReportManager.getTest().skip(
                    result.getThrowable());
        }

        takeScreenshot(result, false);

        ExtentReportManager.removeTest();

        logging.info("============================================");
    }

    private void takeScreenshot(ITestResult result, boolean passed) {

        Object instance = result.getInstance();

        if (instance instanceof DriverSetup) {

            DriverSetup test = (DriverSetup) instance;
            WebDriver driver = test.getDriver();

            if (driver != null) {

                ScreenshotUtil ss = new ScreenshotUtil(driver);

                if (passed) {
                    ss.screenshotSuccessClass(result.getName());
                } else {
                    ss.screenshotFailureClass(result.getName());
                }

            } else {
                logging.warn(
                        "Driver is null. Screenshot skipped for: "
                                + result.getName());
            }

        } else {
            logging.warn(
                    "Test class does not extend DriverSetup: "
                            + result.getName());
        }
    }

    @Override
    public void onStart(ITestContext context) {

        ExtentReportManager.getInstance();

        logging.info("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        logging.info("Test Suite Finished: " + context.getName());

        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(
            ITestResult result) {
        logging.warn("Test partially failed: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }
}