package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MetodosComunes {
	
	//VARIABLES DE CLASE
	WebDriver driver;
	WebElement element, element1;
	
	
	//Constructor de la clase
	public MetodosComunes(WebDriver driver){
		this.driver = driver;
	}
		
	
	
		/**
		 * @Descripcion_Del_Metodo Este metodo abre 1 explorador entre Chrome, Firefox o Edge
		 * @Autor Jorge omar Hernandez Flores - Yonch100
		 * @Fecha de creacion: Martes 31 Agosto 2021
		 * 
		 * @param url
		 * @param explorador
		 * @return driver
		 * @exception NA
		 * 
		 */
		  public WebDriver inicializarExplorador(String url) {	  
				//Web Driver
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver\\chromedriver.exe");
				ChromeOptions chromeOption = new ChromeOptions();
				chromeOption.addArguments("--incognito");
				driver = new ChromeDriver(chromeOption);
				driver.get(url);
				driver.manage().window().maximize();
			  return driver;
			
		  }
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo ingresa texto a un textbox
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement element
			 * @param String 
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void sendText(WebElement element, String texto) {
			  element.clear();
			  scroll1(element);
			  element.sendKeys(texto);
			  Reporter.log("El texto a ingresar es: " + texto, true); //Linea para que sea visible en el reporte de ejecucion
		  }
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo es para realizar un clic a un elemento web
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement element
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void clicButton (WebElement element) {
			  	element.click();
		  }
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo es para realizar doblr clic a un elemento web
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Lunes 25 Agosto 2022
			 * 
			 * @param WebElement element
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void doubleClic (WebElement element, String xpath) {
			  Actions act = new Actions(driver);
			  WebElement webelement = driver.findElement(By.xpath(xpath) ); 
			  act.doubleClick(webelement).perform();
		  }
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Realiza un scroll por medio de la clase Action
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement
			 * @return NA
			 * @exception NA
			 *
			 */
		  public void scroll1(WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
			Reporter.log("Si fue posible realizar scroll en el web element ---> <b>" + element.toString().split("->")[1] +"</b>", true);
		  }  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo realiza un scroll por medio de Javascript
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param Webelement
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void scrollJS(WebElement element) {
			  JavascriptExecutor JSE = (JavascriptExecutor) driver;
			  JSE.executeScript("arguments[0].scrollIntoView(true);", element);
			  
			  //En caso de encontrar o no el web element mostrara en NEGRITAS el XPATH o el locator
			  Reporter.log("Si fue posible realizar scroll en el web element ---> <b>" + element.toString().split("->")[1] +"</b>", true);
			  //Reporter.log("Si fue posible realizar scroll en el web element ---> <b>" + element.toString().split("By.")[0]+"</b>", true);
		  }
		  
		  
		  
		  


		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo valida si un elemento existe o no
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement element
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public boolean elementExist (WebElement element) {
			  try {
				  element.getSize();
				  return true;
			  }
			  catch (NoSuchElementException e) {
				  return false;
			  }
		  }
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo muestra un nombre aleatoreamente de una lista
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param NA 
			 * @return String
			 * @exception NA
			 * 
			 */
		  public String randomText(){
				//Se crea un arreglo 
				String[] arregloString = new String[] {"Sergio", "Jesica", "Omar", "Irving", "carlos"};
				List <String> listaDeNombres = Arrays.asList(arregloString);
				
				Collections.shuffle(listaDeNombres);
				int index = new Random().nextInt(listaDeNombres.size() );
				String nombre = listaDeNombres.get(index);
				return nombre;
			}
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo genera un numero entero aleatorio
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param Int size
			 * @return String
			 * @exception NA
			 * 
			 */
		  public String randomNumber (int size) {
			  Random numeroRandom = new Random();
			  int numeroTemp = 0;
			  boolean flag = true;
			  
			  while (flag) {
				  numeroTemp = numeroRandom.nextInt();
				  if(Integer.toString(numeroTemp).length() == size &&! Integer.toBinaryString(numeroTemp).startsWith("-") ) {
					 flag = false;
				  }
			  }
			  return String.valueOf(numeroRandom);
		  }

		  

		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo genera un numero entero aleatorio
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param Int size
			 * @return String
			 * @exception NA
			 * 
			 */
		  public String randomNumber2 (int size) {
			  Random numeroRandom = new Random();
			  StringBuilder strbld = new StringBuilder();
			  
			  for (int i=0; i<size; i++) {
				  strbld.append(numeroRandom.nextInt(size) );
			  }
			  return strbld.toString();
		  }
		  
		  
		  
		  
		  
		  /**
		   * 
		   * @Descripcion_Del_Metodo Este metodo genera una fecha
		   * @Autor Jorge omar Hernandez Flores - Yonch100
		   * @Fecha de creacion: Martes 31 Agosto 2021
		   * 
		   * @param Int cantidadDias
		   * @return String fecha
		   * @exception NA
		   * 
		   */
		  public String generateDate(int cantidadDias) {
			  Date miFecha = new Date(); //Genera la fecha actual
			  DateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
			  Calendar calendario = Calendar.getInstance();
			  
			  calendario.setTime(miFecha);
			  calendario.add(Calendar.DATE, cantidadDias);
			  miFecha = calendario.getTime();
			  
			  String fecha = formatoFecha.format(miFecha);
			  
			  return fecha;
		  }
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo genera un screenshot para la evidencia del reporte mailable
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param NA
			 * @return NA
			 * @exception IOException
			 * 
			 */
		  public void takeScreenshot() throws IOException {
			  String path = System.getProperty("user.dir") + "\\test-output\\screenshot\\" + "screen.png";
			  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(srcFile, new File(path) );
			  Reporter.log("<br> <img src ='" + path +  "' height = '400' width = '400' /> </br>");
		  }
		  
		  
		  
		  
		 
		  /**
			 * @Descripcion_Del_Metodo Este metodo es para realizar un clic a un elemento web por medio de JS
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebElement element
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void clicJS (WebElement element) {
			  JavascriptExecutor JSE = (JavascriptExecutor) driver;
			  JSE.executeScript("arguments[0].click();", element);
			  Reporter.log("Si fue posible realizar scroll en el web element ---> <b>" + element.toString().split("->")[1] +"</b>", true);
		  }
		  
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo es para realizar un clic a un elemento web
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param String url
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void navigateInURL(String url) {
			  driver.navigate().to(url);
			  
			  //Linea para saber que url fue abierta por medio de reporter
			  Reporter.log("El url fue abierta correctaemnte [ "+url+" ] ", true);
		  }
		  
		  
		  
		  
		  /**
			 * @Descripcion_Del_Metodo Este metodo es para setear un valor a la variable driver
			 * @Autor Jorge omar Hernandez Flores - Yonch100
			 * @Fecha de creacion: Martes 31 Agosto 2021
			 * 
			 * @param WebDriver driver
			 * @return NA
			 * @exception NA
			 * 
			 */
		  public void setDriver(WebDriver driver) {
			  this.driver = driver;
		  }
		  
		  
		  
		  
		  
		  /**
			 * @Description verify element is present 
			 * @author Sergio.Ramones
			 * @Date 09/04/2021
			 * @parameter WebElement
			 * */
			public void waitForElement(WebElement webElement) {
				try {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );
					wait.until(ExpectedConditions.visibilityOf(webElement) );
					wait.until(ExpectedConditions.elementToBeClickable(webElement) );
					Reporter.log("Element is present in the page", true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				
				/*
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
					click on the compose button as soon as the "compose" button is visible
				driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
				 
				EXPLICITY WAIT
				WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
				        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
				*/
			}
			

		  
	
}
