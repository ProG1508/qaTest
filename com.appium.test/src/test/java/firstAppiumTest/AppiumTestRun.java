package firstAppiumTest;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTestRun {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");

        // Device
        capabilities.setCapability("appium:deviceName", "23028RN4DI");
        capabilities.setCapability("appium:udid", "JZL7EYX8JVBAPFYH");
        capabilities.setCapability("appium:platformVersion", "13");

        // Application
        capabilities.setCapability("appium:appPackage", "com.yespaynxt.uat");
        capabilities.setCapability("appium:appActivity", "com.yespaynxt.MainActivity");

        // Keep app data
        capabilities.setCapability("appium:noReset", true);

        // Launch application
        capabilities.setCapability("appium:forceAppLaunch", true);

        // Appium Server
        URI serverURI = URI.create("http://127.0.0.1:4723");

        driver = new AndroidDriver(serverURI.toURL(), capabilities);

        System.out.println("Driver started successfully");

        // Wait 30 seconds for application animation/loading to finish
        Thread.sleep(30000);

        System.out.println("30 seconds completed");
    }

    @Test
    public void verifyApplication() {

    	System.out.println("Test started");

        // Verify we are in the correct application
        String currentPackage = driver.getCurrentPackage();
        System.out.println("Current package: " + currentPackage);
        
        //List of elements
        

        // Click English
        driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='com.yespaynxt.uat:id/tv_local_name_eng' and @text='English']")
        ).click();

        System.out.println("English selected");

        // Click Next
        driver.findElement(
                AppiumBy.id("com.yespaynxt.uat:id/tv_next")
        ).click();

        System.out.println("Next button clicked");

        System.out.println("Test completed successfully");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }

        System.out.println("Driver closed successfully");
    }
}
