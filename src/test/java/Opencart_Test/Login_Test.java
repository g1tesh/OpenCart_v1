package Opencart_Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.Login_page;
import PageObjects.MyAccountPage;
import Utilities.XLSUtility;

public class Login_Test extends Test_BaseClass{
	
	HomePage homepage;
	Login_page loginpage;
	XLSUtility xlsutility;
	MyAccountPage myaccountpage;
	
	@Test(dataProvider = "LoginData")
	public void Test_Login_Page(String email, String pwd, String exp) //throws InterruptedException
	{
		
		homepage = new HomePage();
		homepage.ClickOnMyAccount();
		System.out.println("Clicked on myaccount");
		homepage.ClickonLogin();
		System.out.println("Clicked on login");
		
		System.out.println("Entering Login Page");
		loginpage = new Login_page();
		loginpage.enteremail(email);
		
		
		System.out.println("Entered Email");
		loginpage.enterpasword(pwd);
		
		System.out.println("Entered Password");
		
		
		loginpage.ClickOnSubmit();
		System.out.println("Click on Submit");
		//myaccountpage = new MyAccountPage();
	//	boolean acountpage = loginpage.myaccountdisplay();
		
//		if(exp.equals("Valid"))
//		{
//			System.out.println("1st If condition");
//			System.out.println(acountpage+"1st If condition Status");
//			if(acountpage == true)
//			{
//				System.out.println("Login Successful");
//				loginpage.ClickOnLogout();
//				Assert.assertTrue(true);
//				
//			}
//			else
//				
//			{
//				System.out.println("In else");
//				System.out.println("Login failed");
//				Assert.assertTrue(false);
//			}
//		}
//		
//		
//		if(exp.equals("Invalid"))
//		{
//			System.out.println("2nd If condition");
//			System.out.println(acountpage+"2nd If condition Status");
//			System.out.println(acountpage);
//			if(acountpage == true)
//			{
//				System.out.println("Login Failed, with valid credentials");
//				Assert.assertTrue(false);
//			}
//			else
//				
//			{
//				System.out.println("in 2nd else");
//				System.out.println("Login failed");
//				Assert.assertTrue(true);
//			}
//		}
//		
		
	}
	
	@DataProvider(name = "LoginData")
	public String[][] XLSdata() throws IOException
	{
		xlsutility = new XLSUtility();
		int rowcount = xlsutility.GetRowCount(".\\TestData\\Opencart_LoginData.xlsx");	
		int colcount = xlsutility.GetColcount(".\\TestData\\Opencart_LoginData.xlsx");
		
		String logindata[][] = new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)  //1
		{		
			for(int j=0;j<colcount;j++)  //0
			{
				logindata[i-1][j]= xlsutility.GetData(i, j,".\\TestData\\Opencart_LoginData.xlsx");  //1,0
			}
		}
	return logindata;
	}
	
	
	

}
