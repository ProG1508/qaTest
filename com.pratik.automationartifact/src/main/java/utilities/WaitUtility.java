package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	public WaitUtility (WebDriver driver)
	
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	// Wait for element visibility
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for element to be clickable
    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for title to contain value
    public boolean waitForTitle(String title) {
        return wait.until(ExpectedConditions.titleContains(title));
    }

    // Wait for URL to contain value
    public boolean waitForURL(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }
}
	

