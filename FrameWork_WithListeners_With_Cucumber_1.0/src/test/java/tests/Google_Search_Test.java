package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages_Repository.AddCustomer_Repo;
import pages_Repository.Google_Search_Repo;
import pages_Repository.Login_Repo;

public class Google_Search_Test {
	
	WebDriver driver;
	Google_Search_Repo objSearch; 
	@Test
	public void searchGoogle() throws InterruptedException
	{
	
	//Set System Property of FireFox 
	System.setProperty("webdriver.gecko.driver","C:/WorkSpace/Selenium/geckodriver-v0.11.1-win64/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("http://www.google.com");
	
	objSearch=new Google_Search_Repo(driver);
	
	objSearch.settxtSearchBox();
	objSearch.getListCount();
	System.out.println("Successfully Completed!!!!!!!!!!!!!!!!!");
	}
}
