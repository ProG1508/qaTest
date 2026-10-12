package com.pratik.ypassist.com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReportManager {

	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	private ExtentReportManager() {
	}

	public static synchronized ExtentReports getInstance() {
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");

			spark.config().setDocumentTitle("YP Assist Automation Report");

			spark.config().setReportName("Test Execution Report");

			extent = new ExtentReports();
			extent.attachReporter(spark);

			extent.setSystemInfo("Framework", "Selenium");
			extent.setSystemInfo("Test Runner", "TestNG");
		}

		return extent;
	}

	public static ExtentTest getTest() {
		return test.get();
	}

	public static void removeTest() {
		test.remove();
	}

	public static synchronized void flushReport() {
		if (extent != null) {
			extent.flush();
		}
	}

	public static void createTest(String testName) {
		// TODO Auto-generated method stub
		test.set(getInstance().createTest(testName));
	}

}