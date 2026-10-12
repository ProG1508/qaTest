package com.pratik.ypassist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {

	WebDriver driver;

	public ElementsPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='/text-box']")
	WebElement eleTextBox;

	@FindBy(xpath = "//a[normalize-space()='Check Box']")
	WebElement eleCheckBox;

	@FindBy(xpath = "//li[@id='item-2']")
	WebElement eleRadioButton;

	@FindBy(xpath = "//a[@href='/webtables']")
	WebElement eleWebtables;

	@FindBy(xpath = "//a[normalize-space()='Links']")
	WebElement eleButtons;

	@FindBy(xpath = "//a[@href='/links']")
	WebElement eleLinks;

	@FindBy(xpath = "//a[normalize-space()='Broken Links - Images']")
	WebElement eleBrokenLinks;

	@FindBy(xpath = "//span[contains(text(),'Upload and Download')]")
	WebElement eleUploadDownload;

	@FindBy(xpath = "//a[normalize-space()='Dynamic Properties']")
	WebElement eleDynamicProperties;

	public void eleTextBoxClick() {
		eleTextBox.click();
	}
}
