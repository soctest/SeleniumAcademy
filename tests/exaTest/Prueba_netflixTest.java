package exaTest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Utility.Helpers;
import com.Utility.TestNGCreation;

public class Prueba_netflixTest extends TestNGCreation {
	
	ElementFactory element = new ElementFactory();
	Helpers helper = new Helpers();
	String email = "";
	
	public Prueba_netflixTest(String emailTst) {
		this.email = emailTst;
	}
	
	@Test (dependsOnMethods = {"dataProviderEmailTest"})
	@Parameters({"title"})
	public void validarTituloTest(String netFlixTitle) {
		
		try {
			String actualTitle = MainPage.pageTitle(driver);
			s_assert.assertTrue(actualTitle.contains(netFlixTitle));
			System.out.println("The Netflix title is as expected!");
		} catch (Exception e) {
			System.out.println("The Netflix title is not as expected. Element does not exist!"+ e.getMessage());
		}
		System.out.println("\n");

	}
	
	@Test(dependsOnMethods = {"validarTituloTest"})
	@Parameters({"title", "tagName"})
	public void iniciarSesionPageTest(String netFlixTitle, String tagName) {
		
		try {
			driver.findElement(By.xpath(element.iniciarSesion)).click();
			String actualTitle = MainPage.pageTitle(driver);
			s_assert.assertFalse((actualTitle.contains(netFlixTitle)));
			System.out.println("The Netflix title has changed to "+ actualTitle);
		} catch (Exception e) {
			System.out.println("The Netflix title has not changed. Element does not exist!"+ e.getMessage());
		}
				
		try {
			List<WebElement> tagNameList = driver.findElements(By.tagName(tagName));
			for (WebElement e : tagNameList) {
				if (e.getText().contains("Sign In")) {
					System.out.println(""+ e.getText() +" has been found in h1s");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Sign In is not displayed"+ e.getMessage());
		}
		
		try {
			s_assert.assertTrue(driver.findElement(By.xpath(element.facebookSignIn)).isDisplayed());
			System.out.println("The 'Login with Facebook' text is displayed as expected!");
		} catch (Exception e) {
			System.out.println("Has ocurred an error!"+ e.getMessage());
		}
		
		System.out.println("\n");
	}
	
	@Test(dependsOnMethods = {"iniciarSesionPageTest"})
	@Parameters({"netflixEmailWrong", "netflixEmailWell", "netflixPass", "netflixEmailErrMsg", "netflixPasswErrMsg"})
	public void loginToNetflixErrorTest (String netflixEmailWrong, String netflixEmailWell, String netFlixPass, String netflixEmailErrMsg, String netflixPasswErrMsg) {
		
		try {
			driver.findElement(By.xpath(element.iniciarSesion)).click();
			driver.findElement(By.xpath(element.netflixRememberMe)).click();
			driver.findElement(By.xpath(element.netflixSignInBtn)).click();
			
			String netfEmailErrMsg = MainPage.loginEmailErrMsg(driver, driver.findElement(By.xpath(element.netFlixEmailErrMsglocator)));
			s_assert.assertTrue(netfEmailErrMsg.contains(netflixEmailWrong));
			System.out.println("The Email error message '"+ netflixEmailErrMsg +"' is displayed as expected!");	
		} catch (Exception e) {
			System.out.println("The Email error message '"+ netflixEmailWrong +"' is not displayed as expected! or element does not exist!"+ e.getMessage());
		}

		try {
			driver.findElement(By.xpath(element.netflixEmail)).sendKeys(netflixEmailWell);
			driver.findElement(By.xpath(element.netflixPass)).sendKeys(netFlixPass);
			driver.findElement(By.xpath(element.netflixRememberMe)).click();
			driver.findElement(By.xpath(element.netflixSignInBtn)).click();
			
			String netPasswfErrMsg = MainPage.loginPasswErrMsg(driver, driver.findElement(By.xpath(element.netFlixPasswErrMsglocator)));
			s_assert.assertTrue(netPasswfErrMsg.contains(netflixPasswErrMsg));
			System.out.println("The Password error message '"+ netPasswfErrMsg +"' is displayed as expected!");
		} catch (Exception e) {
			System.out.println("The Password error message '"+ netflixPasswErrMsg +"' is NOT displayed as expected!"+ e.getMessage());
		}
		
		System.out.println("\n");
	}
	
	@Test (dataProvider = "emails", dataProviderClass = DataGenerator.class)
	public void dataProviderEmailTest (String emailTest) {
		try {
			driver.findElement(By.xpath(element.iniciarSesion)).click();
			driver.findElement(By.xpath(element.netflixEmail)).sendKeys(emailTest);
			driver.findElement(By.xpath(element.signUpNow)).click();
			helper.sleepSeconds(2);
			System.out.println("Emails has been filled "+ emailTest +" succcessfully");
		} catch (Exception e) {
			System.out.println("Hubo un error "+ e.getMessage());
		}
		
		System.out.println("\n");
	}

}
