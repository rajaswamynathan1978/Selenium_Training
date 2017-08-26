package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import pages_Repository.AddCustomer_Repo;
import pages_Repository.LogOut_Repo;
import pages_Repository.Login_Repo;

public class AddCustomer_Grid_Test_Guru99 {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileInputStream file;
	private EventFiringWebDriver e_driver;
	private genericLibrary.EventListener eventListener;
	
	WebDriver driver;
	Login_Repo ObjLogin;
	LogOut_Repo ObjLogOut;
	AddCustomer_Repo ObjAddCustomer;
	String baseURL="http://newtours.demoaut.com/";
	String nodeURL="http://192.168.0.23:4447/wd/hub";
		
	Map<String,String> inputData_Dict=new HashMap<String,String>();
	@BeforeTest
	public void setUp() throws IOException, InterruptedException
	{
		// Read Input From Properties File
		System.setProperty("webdriver.gecko.driver","C:/WorkSpace/Selenium/geckodriver-v0.11.1-win64/geckodriver.exe");		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
 		cap.setCapability("platform", Platform.WIN10);
		cap.setCapability("binary", "C:/Program Files/firefox.exe"); //for linux
		cap.setPlatform(Platform.WIN10);
		cap.setVersion("50.1.0");	
		cap.setCapability("marionette", true);
		
		driver = new RemoteWebDriver(new URL("http://192.168.0.23:4445/wd/hub"), cap);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void simpleTest()
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
}	
	

	
	
