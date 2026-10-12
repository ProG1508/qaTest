package base;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

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

        // Keep application data
        capabilities.setCapability("appium:noReset", true);

        URI serverURI = URI.create("http://127.0.0.1:4723");

        driver = new AndroidDriver(serverURI.toURL(), capabilities);

        System.out.println("Appium driver started successfully");
    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Appium driver closed successfully");
    }
}