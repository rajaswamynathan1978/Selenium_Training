package pages_Repository;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOut_Repo {
	
	WebDriver driver;
	By lnkLogOut=By.xpath("//a[contains(@href,'Logout.php')]");
	
	final static Logger mylog = Logger.getLogger("appLog");
	
	public LogOut_Repo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickLogOutLink() throws IOException, InterruptedException
	
	{
		driver.findElement(lnkLogOut).click();
		Runtime.getRuntime().exec("C:/WorkSpace/Selenium/AutoIt_Scripts/closeLogOutDialog.exe");
		//driver.close();
		//driver.quit();
		mylog.info("LogOut is clicked and Dialog is closed");
	}

}