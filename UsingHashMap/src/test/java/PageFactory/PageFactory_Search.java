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
	
	@FindBy(xpath = ".//*[@id='ctl00_ContentPlaceHolder1_ibtnSrch']")
	WebElement srchbutton;
	
	@FindBy(xpath = "//td//span[@id='ctl00_ContentPlaceHolder1_lblTopListn']")
	WebElement results;
	
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
	
	public void click_searchbutton()
	{
		srchbutton.click();
	}
	
	public String get_results()
	{
		return results.getText().split(" ")[3];
	}

}
