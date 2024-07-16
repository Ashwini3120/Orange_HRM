package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.UtilClass;

public class Login_Scenario2 extends UtilClass {
	

		WebDriver driver;
		
		@FindBy(xpath="//input[@name='username']")
		private WebElement username;

		@FindBy(xpath="//input[@name='password']")
		private WebElement paswrd;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement submit;
		
		public Login_Scenario2(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
		}
		
		public void testLogin() throws IOException, InterruptedException {
		explicitWait(driver,username);
		username.sendKeys("Admin");
		paswrd.sendKeys("admin123");
		submit.click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login Fail");
		System.out.println("Login Successfull");
		getScreenshot(driver);
			
			}
}
