package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

public class BaseSetup {
	
	WebDriver driver;
	
	
	@BeforeSuite
	public void baseSetup()
	{
		if(driver == null)
		{
			
		}
		
		
		
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.close();
	}

}
