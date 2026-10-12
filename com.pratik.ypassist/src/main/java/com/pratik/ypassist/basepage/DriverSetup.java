package com.pratik.ypassist.basepage;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.pratik.ypassist.com.utilities.ConfigFileReader;

public class DriverSetup {

	protected WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void driverSetupClass() throws Exception {

		ConfigFileReader configReader = new ConfigFileReader();

		Properties prop = configReader.getProperties();
		
		prop.getProperty("browser");
		if (browser == null || browser.isBlank()) {	
		    throw new IllegalStateException(
		            "Browser is missing in config.properties");
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("InternetExplorer")) {
			driver = new InternetExplorerDriver();
		}

		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
