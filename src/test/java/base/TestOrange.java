package base;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestOrange {
  
		//Se inicializan variables en la clase 
			String url = "https://opensource-demo.orangehrmlive.com/";
			WebDriver driver;
		
		//Creacion del objeto de las clases a utilizar
			LoginOrangePom lpp;
			MetodosComunes metodos;
			
		
		@BeforeTest
	  public void abrirExplorador() {
		//Se llama al metodo inicializarExplorador del objeto metodocomun1 de la clase metodo comun, pasandole las variables url y explorador
			metodos = new MetodosComunes(driver);
			driver = metodos.inicializarExplorador(url);
			lpp = new LoginOrangePom(driver);
	  }

		@AfterTest
		public void tearDown() {
			driver.quit();
			Reporter.log("el driver se ha cerrado", true);
		}
		
		//-------------------------------------------------------------------------------------
		
		
		/**
		 * Test
		 */
		@Test
		public void errorlogin(){
			lpp.errorLogin1();
		}
		
		@Test
		public void login(){
			lpp.ingresarLogin("Admin", "admin123");
		}
  
		
		
		
		
		
		
		
}