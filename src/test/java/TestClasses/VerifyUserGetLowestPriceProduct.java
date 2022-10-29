package TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.Base1;
import PomClasses.homepage;
import PomClasses.homepage;

public class VerifyUserGetLowestPriceProduct {

	WebDriver driver;
	homepage hp;
	
	 @BeforeClass
	    @Parameters("browser")
		public void beforeClass(String browser) {
	    	driver = Base1.getDriver(browser);
	}
	 
	@BeforeMethod
	public void beforeMethod() {
		hp = new homepage(driver);
	}
	
	@Test
	public void VerifyUserGetLowestPriceProduct(){
		hp.searchProduct();
		
		for(int i=1; i<=5; i++) {
			if (i!=1) {
				hp.switchPage(i);
		}
			
			Assert.assertNotEquals(hp.getLowestPrice(), "");
		  
		}
		
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		Base1.unloadDriver();
	}
}
