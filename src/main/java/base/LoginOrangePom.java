package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrangePom extends MetodosComunes{
	
	/*
	 * Metodo constructtor
	 */
	public LoginOrangePom(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	/*
	 * Localizadores
	 */
	@FindBy(xpath = "//input[contains(@name,'username')]")
	WebElement txtUsername;
	
	@FindBy(xpath = "//input[contains(@name,'password')]")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Login')]")
	WebElement btnLogin;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module'][contains(.,'PIM')]")
	WebElement accessElementValidation;
	
	public void errorLogin1() {
		try {
			waitForElement(txtUsername);
			sendText(txtUsername, "a");
			sendText(txtPassword, "a");
			clicButton(btnLogin);
			WebElement webElement = driver.findElement(By.xpath("//p[contains(.,'Invalid credentials')]") );
			//WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(.,'Invalid credentials')]") ) );
			
			String txtErrorLogin1 = webElement.getText();
			System.out.println(txtErrorLogin1);
			
			//poner un assert equals
			String var = "Invalid credentials";
			assert txtErrorLogin1.equals(var): String.format("El error devuelto no es el corecto");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void ingresarLogin (String usr, String pss) {
		waitForElement(txtUsername);
		sendText(txtUsername, "Admin");
		sendText(txtPassword, "admin123");
		clicButton(btnLogin);
		
		try {
			waitForElement(accessElementValidation);
			boolean searchTextEnabled = driver.findElement(By.xpath("//img[@src='/web/images/orangehrm-logo.png?1660914792648']") ).isEnabled();
			assert searchTextEnabled == true: String.format("El valor es falso");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}