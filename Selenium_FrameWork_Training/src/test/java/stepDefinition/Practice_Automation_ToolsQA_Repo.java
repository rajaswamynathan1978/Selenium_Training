package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice_Automation_ToolsQA_Repo {
	
	WebDriver Driver;
	public Properties prop;

	By txtFirstName=By.name("firstname");
	By txtLastName=By.name("lastname");
	By txtDatePicker=By.id("datepicker");
	By chkProfession=By.id("profession-1");
	By chkAutomationTool=By.id("tool-1");
	By btnBrowse=By.id("photo");
	By lnkFileDownLoad=By.linkText("Test File to Download");
	
	// Log File Settings
	
	final static Logger mylog = Logger.getLogger("appLog");
	
	@Test(priority=0)
	public void LaunchBrowser() throws IOException
	{
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.get("http://toolsqa.com/automation-practice-form/");
		Driver.manage().window().maximize();
	}
 
	/*public Practice_Automation_ToolsQA_Repo(WebDriver Driver)
	{
		this.Driver=Driver;
	}*/
	@Test(priority=1)
	@Parameters({"firstName"})
	public void setFirstName(String firstName)
	{
		Driver.findElement(txtFirstName).sendKeys(firstName);
		mylog.info("FirstName "+ firstName + "is set to Customer Name");
	}
	@Test(priority=2)
	@Parameters({"lastName"})
	public void setLastName(String lastName)
	{
		Driver.findElement(txtLastName).sendKeys(lastName);
		mylog.debug("LastName "+ lastName + "is set to Customer Name");
	}
	@Test(priority=3)
	@Parameters({"sex"})
	public void selectSex(String sex)
	{
		if(sex.trim().equals("m"))
		{
			Driver.findElement(By.id("sex-0")).click();
			mylog.debug("Value Male is set to Sex");			
			
		}
		else
		{
			Driver.findElement(By.id("sex-1")).click();
			mylog.debug("Value Male is set to Sex");	
		}
	}
	@Test(priority=4)
	@Parameters({"years"})
	public void selectYearsOfExperience(String years)
	{
		Driver.findElement(By.xpath("//input[@value='"+years+"']")).click();
		mylog.debug("Years Of Experience " + years+"is set");			
	}
	@Test
	@Parameters({"dte"})
	public void setDate(String dte)
	{
		Driver.findElement(txtDatePicker).sendKeys(dte);
		mylog.debug("Date "+ dte + "is set to Date");
	}		
	@Test
	@Parameters({"profession"})
	public void selectProfession(String profession)
	{
		Driver.findElement(chkProfession).click();
		mylog.debug("Profession "+ profession + "is selected");
	}
	@Test
	@Parameters({"autoTool"})
	public void selectAutomationTool(String autoTool)
	{
		if(autoTool.trim().toLowerCase().equals("qtp"))
		{
			Driver.findElement(By.id("tool-0")).click();
			mylog.debug("QTP is selected ");			
		}
		else if(autoTool.trim().toLowerCase().equals("selenium ide"))
		{
			Driver.findElement(By.id("tool-1")).click();
			mylog.debug("Selenium IDE is selected ");	
		}
		else if(autoTool.trim().toLowerCase().equals("selenium webdriver"))
		{
			Driver.findElement(By.id("tool-2")).click();
			mylog.debug("Selenium WebDriver is selected ");	
		}		
	}
	@Test
	@Parameters({"continent"})
	public void selectContinents(String continent)
	{
		Select dropdown = new Select(Driver.findElement(By.id("continents")));
		//dropdown.selectByIndex(5);
		dropdown.selectByVisibleText(continent);
		mylog.debug("Value "+continent+" is selected ");
	}
	@Test
	@Parameters({"FilePath_Upload"})
	public void upLoadFile(String FilePath_Upload) throws IOException
	{
		Driver.findElement(btnBrowse).click();
		Runtime.getRuntime().exec(FilePath_Upload);
		mylog.debug("File Upload is success");
	}
	@Test
	@Parameters({"FilePath_Download"})
	public void downLoadFile(String FilePath_Download) throws IOException
	{
		Driver.findElement(lnkFileDownLoad).click();
		Runtime.getRuntime().exec(FilePath_Download);
		mylog.debug("File DownLoad is success");
	}
	@Test
	@Parameters({"commands"})
	public void selectSeleniumCommands(String commands) throws InterruptedException
	{
		Select dropdown = new Select(Driver.findElement(By.id("selenium_commands")));
		dropdown.selectByIndex(2);
		dropdown.selectByIndex(3);
		dropdown.selectByIndex(4);
		
		/*String[] commandsValue=new String[5];
		commandsValue=commands.split(",");
		
		for(int j=0;j<commandsValue.length;j++)
		{
			for(int i=0;i<elements.size();i++)
			{
					if(elements.get(i).getText().trim().toLowerCase().equals(commandsValue[j].trim().toLowerCase()))
					{
						//dropdown.selectByVisibleText(commandsValue[j]);
						elements.get(i).click();
						mylog.debug("Value "+commandsValue[j]+" is selected ");
						break;
					}
			}
		}*/
	}

	//public static void main(String args[]) throws IOException, InterruptedException
	/*public void myTest() throws IOException, InterruptedException
	{
		Practice_Automation_ToolsQA_Repo Obj=new Practice_Automation_ToolsQA_Repo();
		Obj.LaunchBrowser();
		
		//Interact With Text Objects
		Obj.setFirstName("Raja");
		Obj.setLastName("S");
		Obj.setDate("02/10/2018");
		
		//Interact with Radio Button
		Obj.selectSex("m");
		Obj.selectYearsOfExperience("7");
		
		//Interact with CheckBox
		Obj.selectProfession("Automation Tester");
		Obj.selectAutomationTool("selenium ide");
		
		//Interact with DropDown (Select more than one option)
		Obj.selectContinents("south africa");
		Obj.selectSeleniumCommands("command");
		
		//Interact with Windows Based Dialog -- Upload a File
		Obj.upLoadFile("C:/Raja/ReadMe.md");
		
		//Interact with Windows Based Dialog -- Download a File
		Obj.downLoadFile("C:\\Raja\\AutoITScripts\\FileDownLoad_1.exe");
	}*/
	
}