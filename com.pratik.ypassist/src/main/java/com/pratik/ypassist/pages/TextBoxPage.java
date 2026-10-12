package com.pratik.ypassist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
	
	WebDriver driver;
	
	public TextBoxPage (WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath = "//input[@id='userName']") WebElement txtFullName;
	
	@FindBy (xpath = "//input[@id='userEmail']") WebElement txtEmail;
	
	@FindBy (xpath = "//textarea[@id='currentAddress']") WebElement txtcurrentAddress;
	
	@FindBy (xpath = "//textarea[@id='permanentAddress']") WebElement txtpermanentAddress;
	
	@FindBy (xpath = "//button[normalize-space()='Submit']") WebElement btnSubmit;
	
	
	public void enterFullName(String userName) {
		txtFullName.sendKeys(userName);
	}
	
	public void enterEmail(String emailId) {
		txtEmail.sendKeys(emailId);
	}
	
	public void enterCurrentAddress(String currentAddress) {
		txtcurrentAddress.sendKeys(currentAddress);
	}
	
	public void enterPermnentAddress(String permanentAddress) {
		txtpermanentAddress.sendKeys(permanentAddress);
	}
	
	public void clickSubmitBtn ()
	{
		btnSubmit.click();
	}

}
