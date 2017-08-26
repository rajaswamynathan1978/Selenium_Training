package stepDef;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import genericLibrary.SetFireFoxProfile;
import pages_Repository.Practice_Automation_ToolsQA_Repo;

public class Practice_Automation_ToolsQA_StepDef {
	
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
	public Properties prop;
	@Given("^Login$")
	public void automationPractice() throws Exception
	{
	
		// Read Input From Properties File
		prop = new Properties();
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
	
	}
	
	@When("^performOnPage$")
	public void performOnPage()
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
		try {
			ObjPractice.upLoadFile("AutoIt_Scripts/FileUpload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ObjPractice.downLoadFile("AutoIt_Scripts/FileDownload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
