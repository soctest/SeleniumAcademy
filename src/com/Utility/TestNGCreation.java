package com.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import exaPage.prueba_netflixPage;

public class TestNGCreation {

	public static String url = "";
	public static WebDriver driver;
	BrowserFactory br = new BrowserFactory();
	
	public prueba_netflixPage MainPage;
	private GetProperties properties = new GetProperties();
	private String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = br.startBrowser(chromeDriverUrl);
		MainPage = PageFactory.initElements(driver, prueba_netflixPage.class);
	}

	@AfterMethod
	public void endTest() {
//		driver.close();
	}
}
