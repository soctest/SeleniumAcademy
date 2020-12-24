package com.Utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class Helpers {

	public void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver wait4PageLayouts(WebDriver driver, int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("La pagína no cargó antes de los 60 seconds");
		}
		return driver;

	}
	
}
