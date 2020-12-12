package exaPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class prueba_netflixPage {
		
	public String pageTitle(WebDriver driver, String url) {
		
		return driver.getTitle();
	}
	
	public String loginEmailErrMsg(WebDriver driver, String url, WebElement element) {
		
		return element.getText();
	}
	
	public String loginPasswErrMsg(WebDriver driver, String url, WebElement element) {
		
		return element.getText();
	}
}
