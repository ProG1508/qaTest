package com.pratik.ypassist.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pratik.ypassist.basepage.DriverSetup;

public class LandingPage{

	WebDriver driver;

	public LandingPage(WebDriver driver)  {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		

	}

	@FindBy(linkText = "a")
	WebElement pageLinkTitle;
	
	@FindBy(linkText = "Elements")
	WebElement linkElements;

	public void getLinks() throws Exception {
		System.out.println("This class executed");
		/*
		 * List<WebElement> links = driver.findElements(By.tagName("a"));
		 * 
		 * for (int i = 0; i < links.size(); i++) { System.out.println(i + " : " +
		 * links.get(i).getText()); }
		 */
		

	}
	
	public void clickElements() 
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript(
	        "arguments[0].scrollIntoView({block: 'center'});",
	        linkElements
	    );

	    linkElements.click();	
		
	}

}
