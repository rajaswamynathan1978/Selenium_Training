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
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages_Repository.AddCustomer_Repo;
import pages_Repository.LogOut_Repo;
import pages_Repository.Login_Repo;

public class AddCustomer_Grid_Test {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileInputStream file;
	private EventFiringWebDriver e_driver;
	private genericLibrary.EventListener eventListener;
	
	WebDriver driver;
	Login_Repo ObjLogin;
	LogOut_Repo ObjLogOut;
	AddCustomer_Repo ObjAddCustomer;
	genericLibrary.Excel_Functions ObjExcel;
	
	Map<String,String> inputData_Dict=new HashMap<String,String>();
	@Test
	public void addCustomer() throws IOException, InterruptedException
	{
		// Read Input From Properties File
		Properties prop = new Properties();
		InputStream input = null;
		
		input = new FileInputStream("src/test/resources/config.properties");
		//prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		// load a properties file
		prop.load(input);
		System.setProperty(prop.getProperty("geckoDriver_Name"),prop.getProperty("geckoDriver_Path"));	
		//Desired Capabilities
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WIN10);
		cap.setVersion("50.1.0");
		cap.setCapability("marionette", false);
		cap.setCapability("firefox_binary",new File(prop.getProperty("FireFox_Path")).getAbsolutePath());
		//cap.setCapability("firefox_binary",new File(prop.getProperty("FireFox_Path")).getAbsolutePath());
		/*File file=new File("C:/WorkSpace/Selenium/chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		cap.setVersion("55.0.2883.87");
		cap.setCapability("marionette", true);*/
		//cap.setCapability("firefox_binary",new File(prop.getProperty("FireFox_Path")).getAbsolutePath());
		//cap.setCapability("chrome",new File("C:/WorkSpace/Selenium/chromedriver_win32/chromedriver.exe").getAbsolutePath());
	driver=new RemoteWebDriver(new URL(prop.getProperty("nodeURL")),cap);

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
