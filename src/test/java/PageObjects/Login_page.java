package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Opencart_Test.Test_BaseClass;

public class Login_page extends Test_BaseClass {
	
	public Login_page()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id = 'input-email']")
	WebElement mail;
	
	@FindBy(id = "input-password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement submit;
	
	@FindBy(xpath = "//span[text() = 'Checkout']")
	WebElement checkout;
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	
	public boolean myaccountdisplay() 
	{
		return checkout.isDisplayed();
	}
	
	public void ClickOnLogout()
	{
		logout.click();
	}
	
	//Actions
	public void enteremail(String email)
	{
		mail.sendKeys(email);
	}
	
	public void enterpasword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void ClickOnSubmit()
	{
		submit.click();
	}
	
	

}
