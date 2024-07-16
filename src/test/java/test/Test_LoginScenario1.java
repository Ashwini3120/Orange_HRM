package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import factory.FactoryClass;
import pages.LoginPage;
import util.UtilClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class Test_LoginScenario1 {
	WebDriver driver;
	LoginPage lp;
	
	static ExtentSparkReporter reporter;
	static ExtentTest test;
	static ExtentReports report;
	
	@Parameters({"browser"})
	@BeforeClass
	  public void beforeClass(@Optional("browser")String a) {
	
		driver=FactoryClass.getDriver(a);
		reporter=new ExtentSparkReporter("ExtendReports.html");
		report=new ExtentReports();
	    report.attachReporter(reporter);
	    test= report.createTest("LoginTest");
	    
	  }
	
	@BeforeMethod
	  public void beforeMethod() {
			lp=new LoginPage(driver);
	 	 }
	 
 		 
	@Test(dataProvider="dataset" ,dataProviderClass = UtilClass.class)
 	public void verifyUserCanLogin(String user,String password) throws IOException, InterruptedException { 
 		  lp.testLogin(user,password);
 		  lp.verifyLoginwithCredentials();
 		 
 	 	}
 	 	
  @AfterMethod
     public void afterMethod(ITestResult result) {
	  
	   if(result.getStatus()==ITestResult.SUCCESS) {
		   
		  test.log(Status.PASS, "LoginSuccessfully");
		  		  }
	  else {
		  test.log(Status.FAIL,"InvalidCredential Entered");
	       }
    }

  	@AfterClass
  		public void afterClass() {
  		report.flush();
	  	driver.close();
  		}

}
