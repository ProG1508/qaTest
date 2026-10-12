package com.pratik.ypassist.test.pages;

import org.testng.annotations.Test;

import com.pratik.ypassist.basepage.DriverSetup;
import com.pratik.ypassist.pages.ElementsPage;
import com.pratik.ypassist.pages.LandingPage;
import com.pratik.ypassist.pages.TextBoxPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class TestElementPage extends DriverSetup {

	ElementsPage elementsPage;
	TextBoxPage textBoxPage;
	
	private static final Logger log = LogManager.getLogger(TestElementPage.class);

	@Test()
	public void TC_001_TextBox() throws Exception {	
		
		log.info("Clicking the Text Box menu");
		elementsPage.eleTextBoxClick();
		log.info("Text Box menu clicked successfully");

	}
	
	
	
	
	
	@Test
	public void TC_002_EnterName() {
		
		textBoxPage.enterFullName("Pratik Gade");
	}
	
	@Test
	public void TC_003_EnterEmail() {
		textBoxPage.enterEmail("abcd@gmail.com");
	}
	
	@Test
	public void TC_004_EnterCurrentAddress() {
		textBoxPage.enterCurrentAddress("206, B/No - 3, Sector No - 3, MBP, Mahape, Navi Mumbai ");
	}
	
	@Test
	public void TC_005_EnterPermanentAddress()
	{
		textBoxPage.enterPermnentAddress("Pune");
	}
	
	@Test
	public void TC_006_ClickSubmitButton()
	{
		
		textBoxPage.clickSubmitBtn();
	}

	@BeforeTest
	public void beforeTest() throws Exception {

		driverSetupClass();

		LandingPage lp = new LandingPage(driver);

		lp.clickElements();
		
		elementsPage = new ElementsPage(driver);
		textBoxPage = new TextBoxPage(driver);

	}

}
