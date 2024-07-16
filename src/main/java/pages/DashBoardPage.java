package pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.UtilClass;

public class DashBoardPage extends UtilClass {
	
	WebDriver driver;
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']//li//span")
	private List<WebElement> menu;
		
	@FindBy(xpath="(//input[contains(@class,'oxd-input')])[2]")
	private WebElement username;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
	private WebElement userrecord;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	private WebElement userrole;
	
	@FindBy(xpath="//div[@role='listbox']//div[@role='option']")
	private List<WebElement> userOptions;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]")
	private WebElement status;
	
	@FindBy(xpath="//div[contains(@class,'oxd-select-dropdown')]//span")
	private List<WebElement> statusdropdown;
	
		
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void adminList() {
		
		System.out.println("Total menu options are: "+ menu.size());
		
			for(WebElement options:menu) {
			System.out.println(options.getText());
			}
					
			for(WebElement i:menu)
			{
				if(i.getText().contains("Admin"))
				{
					i.click();
					break;
				}	
			}
		}
	
	public void searchByUserName(String usernm) {
		
		System.out.println("Search Employee by UserName");
		explicitWait(driver,username);
		username.sendKeys(usernm);
		submit.click();
		explicitWait(driver,userrecord);
		System.out.println(userrecord.getText());
		getScreenshot(driver);
		
		driver.navigate().refresh();
		
	  }
	
	public void  searchByUserRole() {
		System.out.println("Search Employee by User Role");
		explicitWait(driver,userrole);
		userrole.click();
		
		for(WebElement i:userOptions) {
			
			if(i.getText().contains("Admin")) {
			i.click();	
			break;
			}
		}
		
		submit.click();
		explicitWait(driver,userrecord);
		System.out.println(userrecord.getText());
		getScreenshot(driver);
		driver.navigate().refresh();
		
	}
	
	public void searchByUserStatus() {
		explicitWait(driver,status);
		status.click();
		System.out.println("Search Employee by Status 'Enabled'");

		for(WebElement i:statusdropdown)
		{
			if(i.getText().contains("Enabled")) {
			i.click();
			break;
			}
		}
		
		submit.click();
		explicitWait(driver,userrecord);
		System.out.println(userrecord.getText());
		getScreenshot(driver);
	}
	
	
}
