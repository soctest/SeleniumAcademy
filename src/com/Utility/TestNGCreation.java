package com.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import exaPage.prueba_netflixPage;

public class TestNGCreation {
	private static String URL = "https://www.netflix.com/";
	public static WebDriver driver;
	BrowserFactory br = new BrowserFactory();
	public SoftAssert s_assert = new SoftAssert();
	
	public prueba_netflixPage MainPage;
	private GetProperties properties = new GetProperties();
	private String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = br.startBrowser(chromeDriverUrl, URL);
		MainPage = PageFactory.initElements(driver, prueba_netflixPage.class);
	}

	@AfterMethod
	public void endTest() {
		driver.close();
	}
}
