package factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class FactoryClass {
	public static WebDriver getDriver(String a) {
		
		if(a.equals("chrome"))
		{
			WebDriver driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
				
			return driver;
		}
	else if (a.equalsIgnoreCase("firefox")) {
			
			WebDriver driver=new FirefoxDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			return driver;
		}
		else {
			
			WebDriver driver=new EdgeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			return driver;
		}	
	}
}
	


