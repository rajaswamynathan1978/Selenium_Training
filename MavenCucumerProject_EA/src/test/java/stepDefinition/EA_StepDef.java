package stepDefinition;
import java.io.FileInputStream;
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
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import genericLibrary.Excel_Functions;
import genericLibrary.SetFireFoxProfile;
import pages_Repository.Login_Repo;

public class EA_StepDef {
	
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
	Login_Repo Obj;
		
	@Test(priority=0)
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		System.setProperty(prop.getProperty("geckoDriver_Name"),prop.getProperty("geckoDriver_Path"));
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://executeautomation.com/demosite/Login.html");
	    Obj=new Login_Repo(driver);
	}
	@Test(priority=1)
	@When("^User Navigate to LogIn Page then verify it$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		System.out.println(driver.getTitle().toString());
		Assert.assertEquals(driver.getTitle().toString(),"Execute Automation");
	}
	@Test(priority=2)
	
	//@Parameters({"UserName","Password"})
	@And("^User enters UserName and Password")
	//public void user_enters_UserName_and_Password(String UserName,String Password) throws Throwable {
	public void user_enters_UserName_and_Password() throws Throwable {
		Obj.setUserName("raja");
		Obj.setPassword("test123");
		Obj.clickSubmit();
	}
	@Test(priority=3)
	@Then("^Verify Login is Successful$")
	public void message_displayed_Login_Successfully() throws Throwable {
		Assert.assertEquals(driver.getTitle().toString(),"Execute Automation");
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
