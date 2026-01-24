package locatorsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseSetup;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	//Locators
	By username_loc = By.xpath("//input[@placeholder='Username']");
	By password_loc = By.xpath("//input[@placeholder='Password']");
	By login_btn_loc = By.xpath("//button[normalize-space()='Login']");
	
	//Action Methods
	public void setUserName(String userName) {
		
		driver.findElement(username_loc).sendKeys(userName);
		
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(password_loc).sendKeys(pwd);
	}

	public void loginButton ()
	{
		driver.findElement(login_btn_loc).click();
	}
}
