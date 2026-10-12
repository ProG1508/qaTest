package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	
	private By username = By.id("username");
	
	private By password = By.id("password");
	
	private By submitBtn = By.id("submit");
	
	
	//Methods
	
	public void enterUserName (String userName)
	{
		driver.findElement(username).sendKeys(userName);
	}
	
	public void enterPassword (String passWord)
	{
		driver.findElement(password).sendKeys(passWord);
	}
	
	public void clickLoginBtn()
	{
		driver.findElement(submitBtn).click();
	}
}
