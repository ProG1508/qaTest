package testRun;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LanguagePage;

public class AppiumTestRun extends BaseTest {

    @Test
    public void languageSelectionTest() throws InterruptedException {

        System.out.println("Test started");

        Thread.sleep(30000);

        LanguagePage languagePage = new LanguagePage(driver);

        languagePage.selectEnglish();

        languagePage.clickNext();

        Thread.sleep(5000);

        System.out.println("Language selection completed");
    }
}
