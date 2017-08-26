package pages_Repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Google_Search_Repo {
	
	WebDriver driver;
	By txtSearchBox=By.id("lst-ib");
	//By lstSearchResults=By.cssSelector("ul.sbsb_b");
	By lstSearchResults=By.xpath("//ul[contains(@class,'sbsb_b')]//li");
	
	final static Logger  mylog = Logger.getLogger("appLog");
	//final static Logger mylog = Logger.getRootLogger();
	
	public Google_Search_Repo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void settxtSearchBox()
	
	{
		driver.findElement(txtSearchBox).sendKeys("selenium testing ");
		mylog.debug(txtSearchBox.toString() + "is clicked");

	}
	
	public void getListCount() throws InterruptedException
	{
		Thread.sleep(5000);
		List<WebElement> lstListBox=driver.findElements(lstSearchResults);
		
		mylog.debug("Total Number of Items " + lstListBox.size());
	}
}
