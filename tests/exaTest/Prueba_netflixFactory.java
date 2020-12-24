package exaTest;

import org.testng.annotations.Factory;

public class Prueba_netflixFactory {

	@Factory
	public Object[] factoryMethod() {
		return new Object[] {
			new Prueba_netflixTest("test@test.com"), 
			new Prueba_netflixTest("test@test2.com")
		};
	}
}
