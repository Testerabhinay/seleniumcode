package Genericlibrary;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseSetUp 
{
	public ExtentReports extent;
	public ExtentTest test;
	ATUTestRecorder recorder;
	
	@BeforeClass(alwaysRun=true)
	public void setreport()
	{
		extent =  ExtentReportsSetup.getReporter("D:\\new learning\\UsingHashMap\\extentreports\\AdvancedReport_"+GetTimeStampValue()+".html");
	}
	
	
	public static WebDriver driver = null;
	
	@BeforeTest(alwaysRun=true)
	@Parameters("browser")
	public void launchApp(String browser) throws IOException,MalformedURLException, ATUTestRecorderException
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			recorder = new ATUTestRecorder("D:\\new learning\\UsingHashMap\\ScriptVideos","TestVideo-"+GetTimeStampValue(),false);
			recorder.start();
			driver = new FirefoxDriver();
			driver.get("http://www.cb-india.com/Search.aspx?as=1");
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		/*else if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver","D:\\Techavitor\\Softwares\\Seleniumss\\chromebrowser\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://cb-india.com/Search.aspx");
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}*/
	}
	
	/*@AfterMethod
	public void CaptureScreenshot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("D:\\new learning\\UsingHashMap\\screenshots\\"+""+GetTimeStampValue()+".png"));
			System.out.println("Failed Coz Invalid Username and Without Password");
		}
	}*/
	
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
	
	public void captureElementScreenshotaa(WebElement image)throws IOException
	{
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		int Imagewidth = image.getSize().getWidth();
		int ImageHeight = image.getSize().getHeight();
		
		Point point = image.getLocation();
		
		int xcord = point.getX();
		int ycord = point.getY();
		
		BufferedImage img = ImageIO.read(screen);
		
		BufferedImage dest = img.getSubimage(xcord, ycord, Imagewidth, ImageHeight);
		ImageIO.write(dest,"png",screen);
		
		FileUtils.copyFile(screen, new File("D:\\new learning\\UsingHashMap\\screenshots\\element"+""+GetTimeStampValue()+".png"));
	
	}
	
	@AfterTest
	public void stopvideo() throws ATUTestRecorderException
	{
		recorder.stop();
	}
	
	@AfterSuite
	public void endreport()
	{
		extent.endTest(test);
		extent.flush();
	}
}
