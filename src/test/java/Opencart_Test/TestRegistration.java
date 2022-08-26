package Opencart_Test;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.swing.JScrollBar;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import PageObjects.Registration_Confirmation;


public class TestRegistration extends Test_BaseClass{
	
	
	
	@Test(groups = {"Master"})
	public void TestRegistrationpage() throws InterruptedException, IOException
	{
		System.out.println("here");
		HomePage hp = new HomePage();
		hp.ClickOnMyAccount();
		System.out.println("Click on Account executed");
		Thread.sleep(1000);
		hp.ClickOnRegistration();
		System.out.println("Click On registration Executed");
		RegistrationPage rp = new RegistrationPage();
		rp.form();
		Thread.sleep(2000);
		Registration_Confirmation rc = new Registration_Confirmation();
		
		String Title = rp.gettitle();
		System.out.println("Got Title == "+Title);
		
		screenshot();
		Assert.assertEquals(Title, "Register Account", "Does not match");
		
		
		
	}
	
	
}
