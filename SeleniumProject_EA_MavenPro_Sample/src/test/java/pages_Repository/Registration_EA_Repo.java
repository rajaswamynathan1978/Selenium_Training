package pages_Repository;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Registration_EA_Repo {
	
	public WebDriver Driver;
	

	By cboTitile=By.name("TitleId");
	By txtInitial=By.name("Initial");
	By txtFirstName=By.name("FirstName");
	By txtMiddleName=By.name("MiddleName");
	By rdoMale=By.name("Male");
	By rdoFeMale=By.name("FeMale");
	By chkEnglish=By.name("english");
	By chkHindi=By.name("Hindi");
	By btnSave=By.name("Save");
	
	// Log File Settings
	
	final static Logger mylog = Logger.getLogger("abc");
	
	public Registration_EA_Repo(WebDriver Driver)
	{
		this.Driver=Driver;
	}
	public void verifyPage()
	{
		if (this.Driver.getTitle().toString().equalsIgnoreCase("Execute Automation"))
			mylog.info("True. Page Found");
		else
			mylog.info("False. Page Not Found");
	}

	public void selectTitile(String title)
	{
		Driver.findElement(cboTitile).sendKeys(title);
		mylog.info("Title "+ title + "is set");
	}
	

	public void setInitial(String initial)
	{
		Driver.findElement(txtInitial).sendKeys(initial);
		mylog.debug("Initial "+ initial + "is set");
	}
	
	public void setFirstName(String custName)
	{
		Driver.findElement(txtFirstName).sendKeys(custName);
		mylog.info("FirstName "+ custName + "is set to Customer First Name");
	}
	
	public void setMiddleName(String custName)
	{
		Driver.findElement(txtMiddleName).sendKeys(custName);
		mylog.info("MiddleName "+ custName + "is set to Customer Middle Name");
	}
	
	public void selectSex(String sex)
	{
		if(sex.trim().equals("m"))
		{
			Driver.findElement(rdoMale).click();
			mylog.debug("Value Male is set to Sex");			
			
		}
		else
		{
			Driver.findElement(rdoFeMale).click();
			mylog.debug("Value Male is set to Sex");	
		}
	}
	
	public void selectLanguage(String language)
	{
		if(language.equalsIgnoreCase("english"))
		{
			Driver.findElement(chkEnglish).click();
			mylog.debug("Languag " + language+" is set");
		}
		else if(language.equalsIgnoreCase("hindi"))
		{
			Driver.findElement(chkHindi).click();
			mylog.debug("Languag " + language+" is set");			
		}
				
	}
	
	public void clickSave()
	{
		Driver.findElement(btnSave).click();
		mylog.info("Save button is clicked");
	}
}