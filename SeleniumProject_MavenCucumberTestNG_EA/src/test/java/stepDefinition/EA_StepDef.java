package stepDefinition;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
	
	/*@BeforeTest
	public void EA_StepDef1() throws IOException
	{
		System.out.println(" I am here-0");
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		System.setProperty(prop.getProperty("geckoDriver_Name"),prop.getProperty("geckoDriver_Path"));
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://executeautomation.com/demosite/Login.html");
	    Obj=new Login_Repo(driver);
	    Obj1=new Registration_EA_Repo(driver);
	    System.out.println(" I am here-1");
	}*/

		
	@BeforeTest
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		//System.setProperty(prop.getProperty("geckoDriver_Name"),prop.getProperty("geckoDriver_Path"));
		System.setProperty(prop.getProperty("Browser_Type"),prop.getProperty("Chrome_Driver_Path"));
		
		//DesiredCapabilities dc = DesiredCapabilities.firefox();
		//dc.setCapability("marionette", true);
		driver =  new ChromeDriver();
		eventListener=new genericLibrary.EventListener();
		e_driver=new EventFiringWebDriver(driver);
		e_driver.register(eventListener);
		//driver = new FirefoxDriver(dc);
		e_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		e_driver.get("http://executeautomation.com/demosite/Login.html");
	    Obj=new Login_Repo(e_driver);
	    Obj1=new Registration_EA_Repo(e_driver);
	    PropertyConfigurator.configure(prop.getProperty("log4jConfigFilePath"));
	}
	@Test
	@When("^User Navigate to LogIn Page then verify it$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		Thread.sleep(2000);
		System.out.println(e_driver.getTitle().toString());
		Assert.assertEquals(e_driver.getTitle().toString(),"Execute Automation");
	}
	@Test
	
	//@Parameters({"UserName","Password"})
	@And("^User enters UserName and Password")
	//public void user_enters_UserName_and_Password(String UserName,String Password) throws Throwable {
	public void user_enters_UserName_and_Password() throws Throwable {
		Obj.setUserName("raja");
		Obj.setPassword("test123");
		Obj.clickSubmit();
	}
	@Test
	@Then("^Verify Login is Successful$")
	public void message_displayed_Login_Successfully() throws Throwable {
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle().toString(),"Execute Automation");
	}
	
	@Test
	@And("^User is on Registration Page$")
	public void verifyPage() throws InterruptedException
	{
		Thread.sleep(5000);
		Obj1.verifyPage();
	}
	
	@Test
	@And("^User Selects Title$")
	public void selectTitle() throws InterruptedException
	{
		Thread.sleep(5000);
		Obj1.selectTitle("Mr.");
	}
	
	@Test	
	@And("^User Selects Initial$")
	public void setInitial()
	{
		Obj1.setInitial("S");
	}
	@Test
	@And("^User Enters FirstName$")	
	public void setFirstName()
	{
		Obj1.setFirstName("Raja");
	}
	@Test
	@And("^User Enters MiddleName$")	
	public void setMiddleName()
	{
		Obj1.setMiddleName("S");
	}
	@Test
	@And("^User Selects Gender$")	
	public void selectSex()
	{
			Obj1.selectSex("m");	
	}
	@Test
	@And("^User Selects Language$")	
	public void selectLanguage()
	{
		Obj1.selectLanguage("hindi");
				
	}
	@Test
	@And("^User Click on Save$")	
	public void clickSave()
	{
		Obj1.clickSave();
	}	
	
/*	@Test
	@Parameters("browser")
	@Given("^Login And User Enters \"(.*)\"$")
	public void automationPractice(String browser) 
	{
	try
	{
		// Read Input From Properties File
		DesiredCapabilities capability;
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		
		if(browser.equals("InternetExplorer"))
		{
		File file = new File("C:/IEDriverServer_Win32_3.5.1/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		System.out.println((FileUtils.fileExists("src/test/resources/config.properties")));
		capability = DesiredCapabilities.internetExplorer();
		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		//capability.setCapability("requireWindowFocus", true);
		driver = new InternetExplorerDriver(capability);
		
		}
		if(browser.equals("FireFox"))
				{
			System.setProperty(prop.getProperty("geckoDriver_Name"),prop.getProperty("geckoDriver_Path"));
			driver = new FirefoxDriver();
				}
		else if(browser.equals("Chrome"))
		{
			File file1=new File("C:/Users/Raja/Downloads/chromedriver_win32 (1)/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
			driver = new ChromeDriver();
			driver.get(prop.getProperty("URL_ToolsQA_Automation_Practice"));
		}		

		
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
		try {
			System.out.println("File Upload File : " + FileUtils.fileExists("AutoIt_Scripts/FileUpload.exe"));
			ObjPractice.upLoadFile("AutoIt_Scripts/FileUpload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			Thread.sleep(5000);
			ObjPractice.downLoadFile("AutoIt_Scripts/FileDownload.exe");
		} catch (IOException e) 
		{
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
		} */
	}
