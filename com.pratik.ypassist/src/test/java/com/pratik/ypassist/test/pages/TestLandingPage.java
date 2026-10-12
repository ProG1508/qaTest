package com.pratik.ypassist.test.pages;

import org.testng.annotations.Test;

import com.pratik.ypassist.basepage.*;
import com.pratik.ypassist.pages.LandingPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestLandingPage extends DriverSetup {

    LandingPage landingPage;

    @BeforeMethod
    public void setup() throws Exception {

        driverSetupClass();

        landingPage = new LandingPage(driver);
    }

    @Test
    public void TC_001_linksofPages() throws Exception {

        landingPage.getLinks();
    }

    @Test
    public void TC_002_clickOnElements() {

        landingPage.clickElements();
    }

    @AfterMethod
    public void tearDownTest() {

        //tearDown();
    }
}

