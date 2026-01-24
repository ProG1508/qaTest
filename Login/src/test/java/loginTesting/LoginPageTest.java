package loginTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import locatorsClass.LoginPage;

public class LoginPageTest {

	WebDriver driver;

	@BeforeTest
	public void driverSetup() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test
	public void doLogin() throws InterruptedException {
		LoginPage lg = new LoginPage(driver);

		Thread.sleep(3000);

		lg.setUserName("Pratik ABCD ");

		Thread.sleep(3000);

		lg.setPassword("Gade Success");
		Thread.sleep(3000);

		lg.loginButton();
		Thread.sleep(3000);
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}
