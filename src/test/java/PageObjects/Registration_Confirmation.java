package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Opencart_Test.Test_BaseClass;

public class Registration_Confirmation extends Test_BaseClass {
	
		public Registration_Confirmation()
		{
			PageFactory.initElements(driver, this);
		}
	
	
	
	public String Accountconfirmation()
	{
		return driver.getTitle();
	}
}
