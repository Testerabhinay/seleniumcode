package DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

import Genericlibrary.ExcelReadWrite;

public class data_search 
{
	@DataProvider(name = "bsearch")
	public static Iterator<Object[]>getdata() throws IOException
	{
		List<Object[]> alist = new ArrayList<Object[]>();
		ExcelReadWrite xl = new ExcelReadWrite("D:\\new learning\\new\\UsingHashMap\\sampledata.xlsx");
		XSSFSheet Sheet = xl.Setsheet("Sheet1");
		int rowCount = xl.getrowcount(Sheet);
		System.out.println(rowCount);
		for(int i=1;i<rowCount;i++)
		{
			Object[] obj = new Object[1];
			HashMap<String,String>hm = new HashMap<String,String>();
			hm.put(xl.Readvalue(Sheet,0,0),xl.Readvalue(Sheet, i,0));
			hm.put(xl.Readvalue(Sheet,0,1),xl.Readvalue(Sheet, i,1));
			hm.put(xl.Readvalue(Sheet,0,2),xl.Readvalue(Sheet, i,2));
			System.out.println(hm.put(xl.Readvalue(Sheet,0,2),xl.Readvalue(Sheet, i,2)));
			System.out.println(hm.put(xl.Readvalue(Sheet,0,3),xl.Readvalue(Sheet, i,3)));
			obj[0]= hm;
			alist.add(obj);
		}
		
		return alist.iterator();
	}
}
