package exaTest;

import org.testng.annotations.DataProvider;

public class DataGenerator {

	@DataProvider (name = "emails")
	public static Object[][] netflixRegister(){
		
		return new Object[][] {
			{"testing@netflix.com"},
			{"test@test.com"},
			{"seleniumAca@gmail.com"}
		};
	}
	
}
