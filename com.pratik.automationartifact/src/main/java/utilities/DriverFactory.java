package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	
	public static WebDriver getDriver(String browserName)
	{
		
		 if (browserName.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	        } else {
	            throw new IllegalArgumentException("Unsupported browser: " + browserName);
	        }

	        return driver;
	}
	
	public static void quitDriver() {
	    if (driver != null) {
	        driver.quit();
	        driver = null;
	    }

	}
}
