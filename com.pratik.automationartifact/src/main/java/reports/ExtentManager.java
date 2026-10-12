package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	
	private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;

    // Create and configure report
    public static ExtentReports getReport() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

            sparkReporter = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Optional system info
            extent.setSystemInfo("Project Name", "Automation Framework");
            extent.setSystemInfo("Tester", "QA Engineer");
        }

        return extent;
    }

    // Flush report
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

}
