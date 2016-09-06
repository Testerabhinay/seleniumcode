package Genericlibrary;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportsSetup 
{
	public static ExtentReports extent;
	public static ExtentReports getReporter(String filePath) 
	{
		if (extent == null) 
		{
            extent = new ExtentReports(filePath, true);
		}
		return extent;
	}
}
