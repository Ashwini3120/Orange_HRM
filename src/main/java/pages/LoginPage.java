package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.UtilClass;

public class LoginPage extends UtilClass{
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;

	@FindBy(xpath="//input[@name='password']")
	private WebElement paswrd;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
		public void testLogin(String user,String pass) throws IOException {
		explicitWait(driver,username);
		username.sendKeys(user);
		paswrd.sendKeys(pass);
		submit.click();
	}
	
	
		public void verifyLoginwithCredentials() throws InterruptedException {
		
		Thread.sleep(2000);
		 UtilClass.getScreenshot(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login Fail");
		 System.out.println("Login Successfull");
		
		
		}
		
	
}
