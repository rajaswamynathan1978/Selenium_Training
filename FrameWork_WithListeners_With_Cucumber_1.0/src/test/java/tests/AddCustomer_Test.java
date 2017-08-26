package tests;

import java.io.File;
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
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import genericLibrary.SetFireFoxProfile;
import pages_Repository.AddCustomer_Repo;
import pages_Repository.LogOut_Repo;
import pages_Repository.Login_Repo;

public class AddCustomer_Test {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileInputStream file;
	private EventFiringWebDriver e_driver;
	private genericLibrary.EventListener eventListener;
	
	//WebDriver driver;
	Login_Repo ObjLogin;
	LogOut_Repo ObjLogOut;
	AddCustomer_Repo ObjAddCustomer;
	genericLibrary.Excel_Functions ObjExcel;
	
	Map<String,String> inputData_Dict=new HashMap<String,String>();
	@Test
	public void addCustomer() throws Exception
	{
		// Read Input From Properties File
		Properties prop = new Properties();
		InputStream input = null;
		
		input = new FileInputStream("src/test/resources/config.properties");
		//prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		// load a properties file
		prop.load(input);
	
	//Set System Property of FireFox 
		
	System.setProperty(prop.getProperty("geckoDriver_Name"),prop.getProperty("geckoDriver_Path"));
	WebDriver driver = new FirefoxDriver(SetFireFoxProfile.FirefoxDriverProfile());
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	e_driver=new EventFiringWebDriver(driver);
	
	eventListener=new genericLibrary.EventListener();
	
	e_driver.register(eventListener);
		
	e_driver.get(prop.getProperty("URL"));
	
	e_driver.manage().window().maximize();
	
	ObjLogin=new Login_Repo(e_driver);
	
	ObjLogin.setUserName(prop.getProperty("UserName"));
	ObjLogin.setPassword(prop.getProperty("Password"));
	ObjLogin.clickSubmit();
	
	ObjAddCustomer=new AddCustomer_Repo(e_driver);
	
	
		
	// Test Begins Here
	//genericLibrary.Excel_Functions ObjExcel=new genericLibrary.Excel_Functions("C:/WorkSpace/Selenium/TestData/TestData_Guru99Bank.xlsx","AddCustomer");
	genericLibrary.Excel_Functions ObjExcel=new genericLibrary.Excel_Functions(prop.getProperty("TestDataFile"),prop.getProperty("TestDataSheet"));

    inputData_Dict=(Map<String, String>) ObjExcel.ReadExcel();
    
    for ( Map.Entry<String, String> entry : inputData_Dict.entrySet()) 
    {
        String key = entry.getKey();
		String value=inputData_Dict.get(key);
		System.out.println(inputData_Dict.get(key));
		String[] arrData=new String[20];
	
	arrData=value.split("\\|");
	
	ObjAddCustomer.clickNewCustomerLink();
	ObjAddCustomer.setCustomerName(arrData[0]);
	ObjAddCustomer.selectSex(arrData[1]);
	ObjAddCustomer.setDOB(arrData[2]);
	ObjAddCustomer.setAddress(arrData[3]);
	ObjAddCustomer.setCity(arrData[4]);
	ObjAddCustomer.setState(arrData[5]); 
	ObjAddCustomer.setPinNumber(arrData[6]);
	ObjAddCustomer.setPhoneNumber(arrData[7]);
	ObjAddCustomer.setEmailId(arrData[8]);
	ObjAddCustomer.setPassword(arrData[9]);
	ObjAddCustomer.clickSubmit();
	//Runtime.getRuntime().exec("C:/WorkSpace/Selenium/AutoIt_Scripts/EmailIdAlreadyExisits.exe");
	//System.exit(1);
	String custId=ObjAddCustomer.getCustomerId();
	Thread.sleep(3000);
	ObjExcel.writeInfoIntoExcel(prop.getProperty("TestDataFile"),prop.getProperty("TestDataSheet"),key, custId);
	ObjAddCustomer.clickContinue();
	System.out.println("Iteration" +key + "Successfully Completed!!!!!!!!!!!!!!!!!");
	ObjLogOut=new LogOut_Repo(e_driver);
	ObjLogOut.clickLogOutLink();
	arrData=null;
	
	}
	inputData_Dict.clear();
	inputData_Dict=null;
	}
	

}
