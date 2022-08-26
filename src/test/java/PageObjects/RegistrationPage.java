package PageObjects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Opencart_Test.Test_BaseClass;

public class RegistrationPage extends Test_BaseClass {
	
	
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	JavascriptExecutor jse = ((JavascriptExecutor)driver);
	
	@FindBy(id = "input-firstname")
	WebElement firstname;
	@FindBy(id = "input-lastname")
	WebElement lastname;
	@FindBy(id = "input-email")
	WebElement email;
	@FindBy(id = "input-password")
	WebElement password;
	@FindBy (xpath = "//label[@for = 'input-newsletter-yes']")
	WebElement sub;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement submit;
	@FindBy(xpath = "//input[@type = 'checkbox']")
	WebElement checkbox;
	
	
	
	
	//Actions
	
	
	
	
	public void form()
	{
		firstname.sendKeys("Alok");;
		lastname.sendKeys("Mulchandani");
		email.sendKeys(GenerateRandomString() +"@gmail.com");
		password.sendKeys("Talent_123");
		jse.executeScript("arguments[0].click()", sub);
		//sub.click();
		jse.executeScript("arguments[0].click()", submit);

	}
	public String gettitle()
	{
		return driver.getTitle();
	}
	

}
