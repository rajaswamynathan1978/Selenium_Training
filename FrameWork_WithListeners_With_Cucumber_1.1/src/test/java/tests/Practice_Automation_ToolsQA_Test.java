package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import genericLibrary.SetFireFoxProfile;
import pages_Repository.Login_Repo;
import pages_Repository.Practice_Automation_ToolsQA_Repo;

public class Practice_Automation_ToolsQA_Test {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileInputStream file;
	private EventFiringWebDriver e_driver;
	private genericLibrary.EventListener eventListener;
	
	
	WebDriver driver;
	genericLibrary.Excel_Functions ObjExcel;
	genericLibrary.SetFireFoxProfile ObjProfile;
	pages_Repository.Practice_Automation_ToolsQA_Repo ObjPractice;
	Map<String,String> inputData_Dict=new HashMap<String,String>();
	@Test
	public void automationPractice() throws Exception
	{
		// Read Input From Properties File
		Properties prop = new Properties();
		InputStream input = null;
		
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		
		ObjProfile=new genericLibrary.SetFireFoxProfile(); 
	
	//Set System Property of FireFox 
		
	System.setProperty(prop.getProperty("geckoDriver_Name"),prop.getProperty("geckoDriver_Path"));
	WebDriver driver = new FirefoxDriver(SetFireFoxProfile.FirefoxDriverProfile());
	
	e_driver=new EventFiringWebDriver(driver);
	
	eventListener=new genericLibrary.EventListener();
	
	e_driver.register(eventListener);
		
	e_driver.get(prop.getProperty("URL_ToolsQA_Automation_Practice"));
	
	e_driver.manage().window().maximize();
	
//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//	driver.get(prop.getProperty("URL_ToolsQA_Automation_Practice"));
		
	// Test Begins Here
	genericLibrary.Excel_Functions ObjExcel=new genericLibrary.Excel_Functions(prop.getProperty("TestDataFile"),prop.getProperty("TestDataSheet"));

    inputData_Dict=(Map<String, String>) ObjExcel.ReadExcel();
    
    ObjPractice=new Practice_Automation_ToolsQA_Repo(e_driver);
    
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
	ObjPractice.upLoadFile("AutoIt_Scripts/FileUpload.exe");
	ObjPractice.downLoadFile("AutoIt_Scripts/FileDownload.exe");
	ObjPractice.selectAutomationTool(arrData[7]);
	ObjPractice.selectContinents(arrData[8]);
	ObjPractice.selectSeleniumCommands(arrData[9]);
	
	ObjExcel.writeInfoIntoExcel(prop.getProperty("TestDataFile"),prop.getProperty("TestDataSheet"),key, "Success");

	System.out.println("Iteration" +key + "Successfully Completed!!!!!!!!!!!!!!!!!");
	
	arrData=null;
	
	}
	inputData_Dict.clear();
	inputData_Dict=null;
	}
	

}
