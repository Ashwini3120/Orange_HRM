package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class UtilClass {
	WebDriver driver;
	
	//WebDriver Wait
	public static WebElement explicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement waitElement= wait.until(ExpectedConditions.visibilityOf(element));
		return waitElement;
	}
	
	  //Screenshot
	public static void getScreenshot(WebDriver driver)
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest =new File(System.getProperty("user.dir")+"//Screenshot//"+"Login"+System.currentTimeMillis()+".png");
		
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	  //ReadExcelData
		XSSFWorkbook wb;
	@DataProvider(name="dataset")
		public Object [][] excelDataRead()
		{
		File f1=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ExcelData\\data.xlsx");
		  FileInputStream fs;
		  Object data[][]=null;
		try {
			fs = new FileInputStream(f1);
			  wb=new XSSFWorkbook(fs);
			  
			  //number of rows
			  int rows=wb.getSheet("Sheet1").getPhysicalNumberOfRows();
			 
			  //number of cells
			  int cells=wb.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells();
			  
			  
			  //create array as per size of file
			   data=new Object[rows-1][cells];
			  for(int i=1;i<rows;i++)//rows
			  {
				  for(int j=0;j<cells;j++)
				  {
					  data[i-1][j]=wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
					  
				  }
			  }
			  			  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return data;
		}
	
}
