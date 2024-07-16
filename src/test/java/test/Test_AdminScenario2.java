package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import factory.FactoryClass;
import pages.DashBoardPage;
import pages.Login_Scenario2;
import util.UtilClass;

public class Test_AdminScenario2 {
	
	WebDriver driver;
	Login_Scenario2 lp;
	DashBoardPage dp;
	
	static ExtentSparkReporter reporter;
	static ExtentTest test;
	static ExtentReports report;
	
	@Parameters({"browser"})
	@BeforeClass
	  public void beforeClass(@Optional("browser")String a) throws IOException, InterruptedException {
	
		driver=FactoryClass.getDriver(a);
		lp=new Login_Scenario2(driver);
		dp=new DashBoardPage(driver);
		reporter=new ExtentSparkReporter("ExtendReports.html");
		report=new ExtentReports();
	    report.attachReporter(reporter);
	    test= report.createTest("Test");
	    lp.testLogin();
	    
	  }
	
				
	@Test(priority=1)
		public void verifyAdmin(){
		    
			dp.adminList();
	  	   }
	
	@Test(priority=2)
	   public void searchByUsername() {
	
		dp.searchByUserName("Admin");
		
     }
	
	@Test(priority=3)
	   public void searchByUserRole() {
	
		dp.searchByUserRole();
	     }
	
	@Test(priority=4)
	   public void searchByStatus() {
	
		dp.searchByUserStatus();
  }
	@AfterMethod
	public void extendReport(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS, result.getName()+" TestCase Pass Successfully");
		}
		else {
			
			test.log(Status.FAIL,result.getName()+" TestCase get Fail");
		}
		
	}
	
	@AfterClass
		public void afterClass() {
		report.flush();
    	driver.close();
		}
}

