package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest  {
	
	@Test
	public void validTest()
	{
		System.out.println("This is sample Test");
	}
	
	
	@Test
	public void validLogin()
	{
		System.out.println("Test Check");
	}
	
	

	    @Test
	    public void validLoginTest() {

	        // Create LoginPage object
	        LoginPage loginPage = new LoginPage(driver);
	        ConfigReader config = new ConfigReader();
	        
	        System.out.println("Test started");

	        // Enter Username + Password + Click Login
	        loginPage.enterUserName(config.getUsername());
	        loginPage.enterPassword(config.getPassword());
	        loginPage.clickLoginBtn();

	        // Create HomePage object
	        HomePage homePage = new HomePage(driver);

	       

	       
	    }
	
}
