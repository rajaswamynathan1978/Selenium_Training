package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import genericLibrary.Excel_Functions;
import genericLibrary.SetFireFoxProfile;
import pages_Repository.Practice_Automation_ToolsQA_Repo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice_Automation_ToolsQA_StepDef {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileInputStream file;
	private EventFiringWebDriver e_driver;
	private genericLibrary.EventListener eventListener;
	
	
	public WebDriver driver;
	Excel_Functions ObjExcel;
	SetFireFoxProfile ObjProfile;
	pages_Repository.Practice_Automation_ToolsQA_Repo ObjPractice;
	Map<String,String> inputData_Dict=new HashMap<String,String>();
	public Properties prop;
	
	@Test
	@Given("^Login$")
	public void automationPractice() 
	{
	try
	{
		// Read Input From Properties File
		DesiredCapabilities capability;
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		
		/*if(browser.equals("InternetExplorer"))
		{
		File file = new File("C:/IEDriverServer_Win32_3.5.1/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		System.out.println((FileUtils.fileExists("src/test/resources/config.properties")));
		capability = DesiredCapabilities.internetExplorer();
		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		//capability.setCapability("requireWindowFocus", true);
		driver = new InternetExplorerDriver(capability);
		
		}*/
		
			System.setProperty(prop.getProperty("geckoDriver_Name"),prop.getProperty("geckoDriver_Path"));
			driver = new FirefoxDriver();
		/*else if(browser.equals("Chrome"))
		{
			File file1=new File("C:/Users/Raja/Downloads/chromedriver_win32 (1)/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
			driver = new ChromeDriver();
			driver.get(prop.getProperty("URL_ToolsQA_Automation_Practice"));
		}*/		

		
		e_driver=new EventFiringWebDriver(driver);
		
		eventListener=new genericLibrary.EventListener();
		
		e_driver.register(eventListener);
			
		e_driver.get(prop.getProperty("URL_ToolsQA_Automation_Practice"));
		
		e_driver.manage().window().maximize();
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
	}
	}
	@Test
	@When("^PerformOnToolsQAPage$")
	public void performOnPage() throws InterruptedException
	{
		genericLibrary.Excel_Functions ObjExcel = null;
		try {
			ObjExcel = new genericLibrary.Excel_Functions(prop.getProperty("TestDataFile"),prop.getProperty("TestDataSheet"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    inputData_Dict=(Map<String, String>) ObjExcel.ReadExcel();
	    ObjPractice=new Practice_Automation_ToolsQA_Repo(e_driver);
	    
	    //ObjPractice=new Practice_Automation_ToolsQA_Repo(driver);
	    
	    for ( Map.Entry<String, String> entry : inputData_Dict.entrySet()) 
	    {
	        String key = entry.getKey();
			String value=inputData_Dict.get(key);
			String[] arrData=new String[20];
		
		arrData=value.split("\\|");
		ObjPractice.setFirstName(arrData[0]);
		ObjPractice.setLastName(arrData[1]);
		ObjPractice.selectSex(arrData[2]);
		ObjPractice.selectYearsOfExperience(arrData[3]);
		ObjPractice.setDate(arrData[4]);
		ObjPractice.selectProfession(arrData[5]);
		/*try {
			System.out.println("File Upload File : " + FileUtils.fileExists("AutoIt_Scripts/FileUpload.exe"));
			ObjPractice.upLoadFile("AutoIt_Scripts/FileUpload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			ObjPractice.downLoadFile("AutoIt_Scripts/FileDownload.exe");
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ObjPractice.selectAutomationTool(arrData[7]);
		ObjPractice.selectContinents(arrData[8]);
		try {
			ObjPractice.selectSeleniumCommands(arrData[9]);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ObjExcel.writeInfoIntoExcel(prop.getProperty("TestDataFile"),prop.getProperty("TestDataSheet"),key, "Success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Iteration" +key + "Successfully Completed!!!!!!!!!!!!!!!!!");
		
		arrData=null;
		
		}
		inputData_Dict.clear();
		inputData_Dict=null;
		} 
	}
