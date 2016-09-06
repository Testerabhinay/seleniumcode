package testscripts;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Genericlibrary.BaseSetUp;
import Genericlibrary.ExcelReadWrite;
import PageFactory.PageFactory_Search;
//import DataProvider.data_search;

public class Book_search extends BaseSetUp
{
	static Logger log = Logger.getLogger(Book_search.class);
	@Test(dataProvider = "bsearch",dataProviderClass=DataProvider.data_search.class)
	public void valid(HashMap<String,String> hm) throws IOException
	{
		test = extent.startTest("Verifying Search Scenario");
		test.log(LogStatus.INFO,"Teststep","Browser Started");
		log.info("Starting Search Scenario :"+hm);
		PageFactory_Search pom = new PageFactory_Search(driver);
		
		pom.search_book(hm.get("BookSearch"));
		test.log(LogStatus.INFO,"SearchCriteria",hm.get("BookSearch"));
		
		pom.search_author(hm.get("Author"));
		test.log(LogStatus.INFO,"SearchCriteria",hm.get("Author"));
		
		pom.search_publisher(hm.get("Publisher"));
		test.log(LogStatus.INFO, "SearchCriteria",hm.get("Publisher"));
		
		pom.search_bookno(hm.get("ISBN"));
		test.log(LogStatus.INFO,"SearchCriteria",hm.get("ISBN"));
		
		String image = test.addScreenCapture("D:\\new learning\\UsingHashMap\\extentreports\\img.jpg");
		test.log(LogStatus.PASS,"Verify Logo Of The application",image);
		
		pom.click_searchbutton();
		
		// UNcomment below lines for failure scenario
		//pom.click_searchbutton();
		//Alert alert = driver.switchTo().alert();
		//alert.accept();//
	}

	@AfterMethod
	public void CaptureScreenshot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			try
			{
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File("D:\\new learning\\UsingHashMap\\screenshots\\"+""+GetTimeStampValue()+".png"));
				System.out.println("Failed Coz Invalid Username and Without Password");
			}catch(Exception e) 
			{
				System.out.println("Exception while taking screenshot"+e.getMessage());
			}
			
		}
	}
		
	/*@Test
	public void invalid(HashMap<String,String> hm)
	{
		PageFactory_Search pom = new PageFactory_Search(driver);
	}*/
}

