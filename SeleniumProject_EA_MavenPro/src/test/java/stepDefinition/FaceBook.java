package stepDefinition;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import genericLibrary.EventListener;

import genericLibrary.Excel_Functions;
import genericLibrary.SetFireFoxProfile;
import pages_Repository.Login_Repo;
import pages_Repository.Registration_EA_Repo;

public class FaceBook  {
	
	public FileInputStream file;
	public static EventFiringWebDriver e_driver;
		

	public static WebDriver driver;
	Excel_Functions ObjExcel;
	SetFireFoxProfile ObjProfile;
	Map<String,String> inputData_Dict=new HashMap<String,String>();
	public Properties prop;
	Login_Repo Obj;
	Registration_EA_Repo Obj1;
	public static String screenShotFolderPath;
	final static Logger mylog = Logger.getLogger("abc");
	private genericLibrary.EventListener eventListener;
	@Test(priority=0)
	public void FaceBook_Login() 
	{
	try
	{
		// Read Input From Properties File
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		//log4j config file path
		PropertyConfigurator.configure(prop.getProperty("log4jConfigFilePath"));

		screenShotFolderPath=prop.getProperty("ScreenShot_Folder_Path");
		
		File file = new File(prop.getProperty("Edge_Driver"));
		System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
		
		eventListener=new genericLibrary.EventListener();
		
		driver = new EdgeDriver();
		e_driver=new EventFiringWebDriver(driver);
		e_driver.register(eventListener);			
		e_driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		e_driver.findElement(By.id("email")).sendKeys("raja");
		mylog.info("Raja is set to Email");
		e_driver.findElement(By.id("pass")).sendKeys("testing");
		mylog.info("testing is set to Password");
		//e_driver.findElement(By.id("u_0_2")).click();
		//mylog.info("Login Button is clicked");
		Thread.sleep(2000);		
		Assert.assertEquals(e_driver.getTitle(),"abc");
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
	}
	finally
	{
		//e_driver.close();
	}
	}
		}
