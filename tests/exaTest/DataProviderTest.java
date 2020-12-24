package exaTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@DataProvider(name = "personas")
	public Object[][] rearPersonas(){
		return new Object[][] {
			{"Juan", 36},
			{"Maria", 37}
		};
	}
	
	@Test(dataProvider = "personas")
	public void nombresPrueba(String nombre, Integer edad) {
		System.out.println("El nombre es "+ nombre +" de edad "+ edad);
	}
	
	@Test(dataProvider = "capitales", dataProviderClass = DataGenerator.class)
	public void imprimirCapitales(String capital, String pais) {
		System.out.println("La capital del pais "+ pais +" es "+ capital);
	}
}
