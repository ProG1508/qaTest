package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {
	
	
	
	public WebDriver driver;
	
	ConfigReader cr = new ConfigReader ();
	
	@BeforeMethod
	public void setUp ()
	{
		driver = DriverFactory.getDriver(cr.getBrowser());
		
		driver.get(cr.getURL());
		
		System.out.println("Driver initialized successfully");
	}
	
	@AfterMethod
	public void tearDown ()
	{
		DriverFactory.quitDriver();
	}

}
