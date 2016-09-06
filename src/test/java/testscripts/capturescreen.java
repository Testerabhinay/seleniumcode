package testscripts;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class capturescreen 
{
	WebDriver driver;
	
	@Test
	public void capturess()
	{
		driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='emailasdasdas']")).sendKeys("Learn automation");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("D:\\new learning\\UsingHashMap\\screenshots\\"+""+GetTimeStampValue()+".png"));
			System.out.println("Failed Coz Invalid Username and Without Password");
		}
	}
	
	
	public String GetTimeStampValue()
	{
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString();
		System.out.println(timestamp);
		String systime = timestamp.replace(":","_");
		System.out.println(systime);
		return systime;
	}
}
