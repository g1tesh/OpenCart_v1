package PageObjects;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Opencart_Test.Test_BaseClass;


public class HomePage extends Test_BaseClass  {
     

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Page Elements
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myaccount;
	
	@FindBy(linkText = "Register")
	WebElement register;
	
	@FindBy(linkText = "Login")
	WebElement login;
	
	//Action Methods
	
	public void ClickOnMyAccount()
	{
		myaccount.click();
	}
	
	public void ClickOnRegistration()
	{
		register.click();
	}
	
	public void ClickonLogin()
	{
		login.click();
	}

}
