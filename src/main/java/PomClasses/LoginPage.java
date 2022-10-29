package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtillClasses.Util1;

public class LoginPage extends Util1{

	 WebDriver driver;
	  
	  @FindBy(xpath="(//input[@type='text'])[2]")
	  private WebElement MobNo;
	  
	  @FindBy(xpath="//input[@type='password']")
	  private WebElement password;
	  
	  @FindBy(xpath="(//button[@type='submit'])[2]")
	  private WebElement loginBtn;
	
		public LoginPage(WebDriver driver) {//constructor
			PageFactory.initElements(driver, this);
			this.driver = driver;  
		}
		
		public void enterID() throws IOException {
			MobNo.sendKeys(getDataFromConfig("MobNO"));	
		}
		 public void enterpassword() throws IOException {
			password.sendKeys(getDataFromConfig("password"));
		}
		public void clickonloginBtn() {
		    loginBtn.click();
		 }
}