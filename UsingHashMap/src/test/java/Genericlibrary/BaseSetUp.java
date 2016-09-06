package Genericlibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSetUp 
{
	public static WebDriver driver = null;
	
	public void launchApp()
	{
		driver = new FirefoxDriver();
		driver.get("http://www.cb-india.com/Search.aspx?as=1");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
