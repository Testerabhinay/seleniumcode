package Genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class utilityclass 
{
	public static String getPropertyvalue(String key)throws Exception
	{
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
}
