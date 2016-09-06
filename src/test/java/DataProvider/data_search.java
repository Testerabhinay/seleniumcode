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
import Genericlibrary.utilityclass;

public class data_search 
{
	@DataProvider(name = "bsearch")
	public static Iterator<Object[]>getdata() throws Exception
	{
		List<Object[]> alist = new ArrayList<Object[]>();
		//ExcelReadWrite xl = new ExcelReadWrite("D:\\new learning\\UsingHashMap\\testdata123.xlsx");
		ExcelReadWrite xl = new ExcelReadWrite(System.getProperty("user.dir")+utilityclass.getPropertyvalue("XLPATH"));
		XSSFSheet Sheet = xl.Setsheet("Book_Search123");
		int rowCount = xl.getrowcount(Sheet);
		System.out.println(rowCount);
		for(int i=1;i<=rowCount;i++)
		{
			Object[] obj = new Object[1];
			HashMap<String,String>hm = new HashMap<String,String>();
			hm.put(xl.Readvalue(Sheet,0,0),xl.Readvalue(Sheet, i,0));
			hm.put(xl.Readvalue(Sheet,0,1),xl.Readvalue(Sheet, i,1));
			hm.put(xl.Readvalue(Sheet,0,2),xl.Readvalue(Sheet, i,2));
			hm.put(xl.Readvalue(Sheet,0,3),xl.Readvalue(Sheet, i,3));
			hm.put(xl.Readvalue(Sheet,0,4),xl.Readvalue(Sheet, i,4));
			hm.put(xl.Readvalue(Sheet,0,5),xl.Readvalue(Sheet, i,5));
			hm.put(xl.Readvalue(Sheet,0,6),xl.Readvalue(Sheet, i,6));
			//hm.put(xl.Readvalue(Sheet,0,7),xl.Readvalue(Sheet, i,7));
			obj[0]= hm;
			alist.add(obj);
		}
		
		return alist.iterator();
	}
}
