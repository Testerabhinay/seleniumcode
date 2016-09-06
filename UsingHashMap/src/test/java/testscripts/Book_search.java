package testscripts;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Genericlibrary.BaseSetUp;
import Genericlibrary.ExcelReadWrite;
import PageFactory.PageFactory_Search;
//import DataProvider.data_search;

public class Book_search extends BaseSetUp
{
	@Test(dataProvider = "bsearch",dataProviderClass=DataProvider.data_search.class)
	public void valid(HashMap<String,String>hm) throws IOException
	{
		PageFactory_Search pom = new PageFactory_Search(driver);
		System.out.println("Testing Driver");
			pom.search_book(hm.get("Sheet"));
		System.out.println("From DataProvider"); 
		
	}

		
		
}

