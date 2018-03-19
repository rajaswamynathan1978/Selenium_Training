package stepDefinition;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import genericLibrary.Excel_Functions;
import genericLibrary.SetFireFoxProfile;
import pages_Repository.Login_Repo;
import pages_Repository.Registration_EA_Repo;

public class EA_StepDef {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileInputStream file;
	private EventFiringWebDriver e_driver;
	private genericLibrary.EventListener eventListener;
	

	public WebDriver driver;
	Excel_Functions ObjExcel;
	SetFireFoxProfile ObjProfile;
	Map<String,String> inputData_Dict=new HashMap<String,String>();
	public Properties prop;
	Login_Repo Obj;
	Registration_EA_Repo Obj1;
	
	@Test(priority=0)
	public void EA_StepDef1() throws IOException
	{
		//out.println(" I am here-0");
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		////setProperty(prop.getProperty("geckoDriver_Name"),prop.getProperty("geckoDriver_Path"));
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://executeautomation.com/demosite/Login.html");
	    Obj=new Login_Repo(driver);
	    Obj1=new Registration_EA_Repo(driver);
	    PropertyConfigurator.configure(prop.getProperty("log4jConfigFilePath"));
	    //out.println(" I am here-1");
	}
	@Test(priority=1)
	public void Login() throws InterruptedException
	{
		Obj.setUserName("Raja");
		Obj.setPassword("testing");
		Obj.clickSubmit();
	}
	
	@Test(priority=2)
	public void perform()
	{
		Obj1.selectTitile("Mr.");
		Obj1.setInitial("S");
		Obj1.setFirstName("Raja");
		Obj1.setMiddleName("R");
		Obj1.selectSex("m");
		Obj1.selectLanguage("hindi");
		Obj1.clickSave();
	}

		}
