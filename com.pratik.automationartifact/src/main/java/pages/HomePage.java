package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	
	public HomePage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//Locators 
	private By logOutBtn = By.xpath(" //a[normalize-space()='Log out']");
	
	//methods
	
	public void logOutMethod ()
	{
		driver.findElement(logOutBtn).click();
	}
	
	
	
}
