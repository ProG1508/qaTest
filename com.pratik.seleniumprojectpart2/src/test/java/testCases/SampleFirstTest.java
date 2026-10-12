package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleFirstTest {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Test Case Started");
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("abcd");
		
		driver.findElement(By.id("password")).sendKeys("abcd");
		
		driver.findElement(By.id("submit")).click();
		
		
		
		
		
	}

}
