package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.Base1;
import PomClasses.homepage;
import PomClasses.LoginPage;

public class VerifyUserLogin {

	  WebDriver driver;
	    
	  ExtentHtmlReporter htmlReporter;
	  ExtentReports reports;
	  ExtentTest test;
	  
	  
	    LoginPage lp;
	    homepage hp;
	

	    @BeforeClass
	    @Parameters("browser")
		public void beforeClass(String browser) {
	    	htmlReporter = new ExtentHtmlReporter("ExtentReports.html");
	    	reports = new ExtentReports();
	    	reports.attachReporter(htmlReporter);
	    	reports.createTest("VerifyUserLogin");
	    	
	    	driver = Base1.getDriver(browser);
	}
		@BeforeMethod
		public void beforeMethod() {
			lp = new LoginPage(driver);
			hp = new homepage(driver);
		}
		
		@Test
		public void VerifyUserCanLogin() throws IOException {
			lp.enterID();
		    lp.enterpassword();
		    lp.clickonloginBtn();
		    boolean isProfileNameVisible = hp.checkProfileNameVisible();
		    
		    Assert.assertTrue(isProfileNameVisible);
		    
		}
		
		@AfterMethod
		public void afterMethod(ITestResult result) {
			if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, result.getName() +" is passes ");
			}else {
				test.log(Status.FAIL, result.getName() +" is failed ");
			}
			
		}
		
		@AfterClass
		public void afterClass() {
			reports.flush();
			
		}
	    
}
