package pages_Repository;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.internal.util.Function;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.apache.log4j.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Practice_Automation_ToolsQA_Repo {
	
	WebDriver Driver;
	

	By txtFirstName=By.name("firstname");
	By txtLastName=By.name("lastname");
	By txtDatePicker=By.id("datepicker");
	By chkProfession=By.id("profession-1");
	By chkAutomationTool=By.id("tool-1");
	By btnBrowse=By.id("photo");
	By lnkFileDownLoad=By.linkText("Test File to Download");
	
	// Log File Settings
	
	final static Logger mylog = Logger.getLogger("appLog");
 
	public Practice_Automation_ToolsQA_Repo(WebDriver Driver)
	{
		this.Driver=Driver;
	}
	
	public void setFirstName(String custName)
	{
		Driver.findElement(txtFirstName).sendKeys(custName);
		mylog.info("FirstName "+ custName + "is set to Customer Name");
	}
	public void setLastName(String custName)
	{
		Driver.findElement(txtLastName).sendKeys(custName);
		mylog.debug("LastName "+ custName + "is set to Customer Name");
	}
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
	public void selectYearsOfExperience(String years)
	{
		Driver.findElement(By.xpath("//input[@value='"+years+"']")).click();
		mylog.debug("Years Of Expericen " + years+"is set");			
	}
	public void setDate(String dte)
	{
		Driver.findElement(txtDatePicker).sendKeys(dte);
		mylog.debug("Date "+ dte + "is set to Date");
	}		
	
	public void selectProfession(String profession)
	{
		Driver.findElement(chkProfession).click();
		mylog.debug("Profession "+ profession + "is selected");
	}
	
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
	public void selectContinents(String continent)
	{
		Select dropdown = new Select(Driver.findElement(By.id("continents")));
		dropdown.selectByIndex(5);
		mylog.debug("Value "+continent+" is selected ");
	}
	
	public void upLoadFile(String FilePath) throws IOException
	{
		Driver.findElement(btnBrowse).click();
		Runtime.getRuntime().exec(FilePath);
		mylog.debug("File Upload is success");
	}
	
	public void downLoadFile(String FilePath) throws IOException
	{
		Driver.findElement(lnkFileDownLoad).click();
		Runtime.getRuntime().exec(FilePath);
		mylog.debug("File DownLoad is success");
	}
	
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
	
}