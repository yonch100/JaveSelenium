package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginNopCommercePom extends MetodosComunes {

	public LoginNopCommercePom(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*
	 * Localizadores
	 */
	@FindBy(xpath = "//input[contains(@id,'Email')]")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[contains(@id,'Password')]")
	WebElement txtPss;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement btnLogin;
	
	
	public void ingresarLogin (String usr, String pss) {
		
	}
	
	
	public void message1 (String usr, String pss) {
		
	}
	
	
	public void message2 (String usr, String pss) {
		
	}
	
	
	public void message3 (String usr, String pss) {
		
	}
	
}