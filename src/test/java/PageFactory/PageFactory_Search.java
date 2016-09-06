package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactory_Search 
{
	WebDriver driver = null;
	@FindBy(xpath = "//td//input[@id='ctl00_ContentPlaceHolder1_txtCrtria']")
	WebElement srch;
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_txtAuthor']")
	WebElement aut;
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_txtPublisher']")
	WebElement pub;
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_txtIsbn']")
	WebElement bookno;
	
	@FindBy(xpath = ".//*[@id='ctl00_ContentPlaceHolder1_ibtnSrch']")
	WebElement srchbutton;
	
	@FindBy(xpath = "//td//span[@id='ctl00_ContentPlaceHolder1_lblTopListn']")
	WebElement results;
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_pnlLst']/table/tbody/tr[2]/td")
	WebElement res;
	
	public PageFactory_Search(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void search_book(String BookSearch)
	{
		srch.clear();
		srch.sendKeys(BookSearch);
	}
	
	public void search_author(String Author)
	{
		//aut.clear();
		aut.sendKeys(Author);
	}
	
	public void search_publisher(String Publisher)
	{
		pub.clear();
		pub.sendKeys(Publisher);
	}
	
	public void search_bookno(String ISBN)
	{
		//bookno.clear();
		bookno.sendKeys(ISBN);
		
	}
	
	public void click_searchbutton()
	{
		srchbutton.click();
		srch.clear();
		bookno.clear();
		aut.clear();
		pub.clear();
	}
	
	public String get_results()
	{
		return results.getText().split(" ")[3];
	}
	
	public String get_res()
	{
		return res.getText();
	}

}
