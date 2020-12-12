package exaTest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Utility.Helpers;
import com.Utility.TestNGCreation;

public class prueba_netflix extends TestNGCreation {
	
	ElementFactory element = new ElementFactory();
	Helpers helper = new Helpers();
	
	@Test ()
	@Parameters({"title"})
	public void validarTituloTest(String netFlixTitle) {	
		SoftAssert s_assert = new SoftAssert();
		url = "https://www.netflix.com/";
		driver.get(url);
		String actualTitle = MainPage.pageTitle(driver, url);
		s_assert.assertTrue(actualTitle.contains(netFlixTitle), "The Netflix title is as expected!");
		if (s_assert .equals(true)) {
			System.out.println("The Netflix title is as expected!");
		}
	}
	
	@Test(dependsOnMethods = {"validarTituloTest"})
	@Parameters({"title", "tagName"})
	public void iniciarSesionPageTest(String netFlixTitle, String tagName) {
		SoftAssert s_assert = new SoftAssert();
		url = "https://www.netflix.com/";
		driver.get(url);
		driver.findElement(By.xpath(element.iniciarSesion)).click();
		String actualTitle = MainPage.pageTitle(driver, url);
		helper.sleepSeconds(5);
		s_assert.assertFalse((actualTitle.contains(netFlixTitle)), "The Netflix title has changed");
		if (s_assert .equals(true)) {
			System.out.println("The Netflix title has changed");
		}
		
		List<WebElement> tagNameList = driver.findElements(By.tagName(tagName));
		for (WebElement e : tagNameList) {
			if (e.getText().contains("Sign In")) {
				System.out.println(e.getText() +" has been found in h1s");
				break;
			}
		}
		
		s_assert.assertTrue(driver.findElement(By.xpath(element.facebookSignIn)).isDisplayed(), "The 'Login with Facebook' text is displayed as expected!");
		if (s_assert .equals(true)) {
			System.out.println("The 'Login with Facebook' text is displayed as expected!");
		}
	}
	
	@Test(dependsOnMethods = {"iniciarSesionPageTest"})
	@Parameters({"netflixEmailWrong", "netflixEmailWell", "netflixPass", "netflixEmailErrMsg", "netflixPasswErrMsg"})
	public void loginToNetflixErrorTest (String netflixEmailWrong, String netflixEmailWell,String netFlixPass, String netflixEmailErrMsg, String netflixPasswErrMsg) {
		SoftAssert s_assert = new SoftAssert();
		url = "https://www.netflix.com/";
		driver.get(url);
		driver.findElement(By.xpath(element.iniciarSesion)).click();
		helper.sleepSeconds(3);
		driver.findElement(By.id(element.netflixEmail)).sendKeys(netflixEmailWrong);
		driver.findElement(By.id(element.netflixPass)).sendKeys(netFlixPass);
		helper.sleepSeconds(2);
		driver.findElement(By.xpath(element.netflixRememberMe)).click();
		helper.sleepSeconds(2);
		driver.findElement(By.xpath(element.netflixSignInBtn)).click();
		
		String netfEmailErrMsg = MainPage.loginEmailErrMsg(driver, url, driver.findElement(By.xpath(element.netFlixEmailErrMsglocator)));
		s_assert.assertTrue(netfEmailErrMsg.contains(netflixEmailWrong), "The Email error message '"+ netflixEmailErrMsg +"' is displayed as expected!");
		
		if (s_assert .equals(true)) {
			System.out.println("The Email error message '"+ netflixEmailErrMsg +"' is displayed as expected!");
		}
		
		helper.sleepSeconds(2);
		driver.findElement(By.id(element.netflixEmail)).click();
		helper.sleepSeconds(2);
		driver.findElement(By.id(element.netflixEmail)).clear();
		driver.findElement(By.id(element.netflixEmail)).sendKeys(netflixEmailWell);
		driver.findElement(By.xpath(element.netflixSignInBtn)).click();
		
		String netPasswfErrMsg = MainPage.loginPasswErrMsg(driver, url, driver.findElement(By.xpath(element.netFlixPasswErrMsglocator)));
		s_assert.assertTrue(netPasswfErrMsg.contains(netflixPasswErrMsg), "The Password error message '"+ netflixPasswErrMsg +"' is displayed as expected!");
		if (s_assert .equals(true)) {
			System.out.println("The Password error message '"+ netflixPasswErrMsg +"' is displayed as expected!");
		}
	}
	
	
}
