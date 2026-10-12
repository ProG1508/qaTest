package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LanguagePage {

    private AndroidDriver driver;

    // Locators
    private By englishLanguage =
            AppiumBy.xpath("//android.widget.TextView[@resource-id='com.yespaynxt.uat:id/tv_local_name_eng' and @text='English']");

    private By nextButton =
            AppiumBy.id("com.yespaynxt.uat:id/tv_next");

    // Constructor
    public LanguagePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void selectEnglish() {

        WebElement english = driver.findElement(englishLanguage);
        english.click();

        System.out.println("English selected");
    }

    public void clickNext() {

        driver.findElement(nextButton).click();

        System.out.println("Next button clicked");
    }
}

