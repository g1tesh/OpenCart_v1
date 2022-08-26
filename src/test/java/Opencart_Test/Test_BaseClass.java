package Opencart_Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Test_BaseClass {
	
	public static WebDriver driver;
	
	public static ResourceBundle rb;
	
	@BeforeClass(groups = {"Master", "Sanity"})
	public void Setup()
	{
		rb = ResourceBundle.getBundle("config");
		
		if(rb.getString("br").equals("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		
		if(rb.getString("br").equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(rb.getString("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//JavascriptExecutor jse = ((JavascriptExecutor)driver);
	}
	
	@AfterClass(groups = {"Master", "Sanity"})
	public void TeadDown()
	{
		driver.quit();
		
	}
	
	public String GenerateRandomString()
	{
		String RandomString = RandomStringUtils.randomAlphabetic(5);
		return RandomString;
	}
	
	  public void screenshot() throws IOException { 
		  TakesScreenshot ts =  (TakesScreenshot) driver; 
		  File scr = ts.getScreenshotAs(OutputType.FILE);
		  File trg = new File(System.getProperty("user.dir")+"\\Reports\\"+"FailScreenshot"+reportName()+".png");
	 	FileUtils.copyFile(scr, trg); 
	 	}
	 
	
	public String reportName()
	{
		 
		 String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 return "Report_Name - "+timestamp+".html";	
		 
	}

}
