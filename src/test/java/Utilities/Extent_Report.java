package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Opencart_Test.Test_BaseClass;

public class Extent_Report extends Test_BaseClass implements ITestListener{
	
	ExtentSparkReporter sparkreport;
	ExtentReports report;
	ExtentTest test;
	
	 public void onStart(ITestContext context) {
		 
		 
		 String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String RepName = "Report_Name - "+timestamp+".html";	
		 
		 
		 sparkreport = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+RepName);
		 sparkreport.config().setReportName("OpenCartTest_Report");
		 sparkreport.config().setDocumentTitle("OpenCart");
		 sparkreport.config().setTheme(Theme.DARK);
		 
		 report = new ExtentReports();
		 report.attachReporter(sparkreport);
		 report.setSystemInfo("Host Name", "LocalHost");
		 report.setSystemInfo("Tester Name", "Gitesh Patil");
		 report.setSystemInfo("Environment", "UAT");
		 report.setSystemInfo("Platform", "Chrome");
		 
		 
		 
		
		  }
	 public void onTestSuccess(ITestResult result) {
		 
		 test = report.createTest(result.getName());
		 test.log(Status.PASS, "Test is passed - "+result.getName());
		   
		  }
	 
	 public void onTestFailure(ITestResult result)
	 {
		 test = report.createTest(result.getName());
		 test.log(Status.FAIL,"Test is failed - "+result.getName());
			
			  try { 
			  String Screenshotpath =  System.getProperty("user.dir")+"\\Reports\\fail.png";
			  test.addScreenCaptureFromPath(Screenshotpath);
			  
			  } catch (Exception e) {
				  // TODO Auto-generated catch block
			  e.printStackTrace(); 
			  }
			 

	 }
	
	 public void onFinish(ITestContext context)
	 {
		 report.flush();
	 }
	
	

}
