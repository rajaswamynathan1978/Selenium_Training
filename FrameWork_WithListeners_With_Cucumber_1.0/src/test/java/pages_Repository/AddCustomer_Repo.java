package pages_Repository;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
public class AddCustomer_Repo {
	
	WebDriver Driver;
	

	By lnkNewCustomer=By.xpath("//a[contains(@href,'addcustomerpage.php')]");
	By txtCustomerName=By.name("name");
	//By rdoSex=By.xpath("//input[contains(@name,'rad1') and contains(@value,'m')]");
	By txtDOB=By.name("dob");
	By txtAddress=By.name("addr");
	By txtCity=By.name("city");
	By txtState=By.name("state");
	By txtPinNumber=By.name("pinno");
	By txtPhoneNumber=By.name("telephoneno");
	By txtemailId=By.name("emailid");
	By txtPassword=By.name("password");	
	By btnSubmit=By.name("sub");
	By btnReset=By.name("res");
	By txtCustId = By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]");
	By lnkContinue=By.xpath("//a[contains(@href,'Managerhomepage.php')]");
	
	
	// Log File Settings
	
	 final static Logger mylog = Logger.getLogger("appLog");
 
	 //final static Logger mylog = Logger.getRootLogger();

	public AddCustomer_Repo(WebDriver Driver)
	{
		this.Driver=Driver;
	}
	
	public void clickNewCustomerLink() throws InterruptedException
	{
		/*WebDriverWait wait=new WebDriverWait(Driver,60);
		wait.until(ExpectedConditions.elementToBeSelected(lnkNewCustomer));*/
		Thread.sleep(5000);
		if (Driver.findElement(lnkNewCustomer).isDisplayed()==true) 
			Driver.findElement(lnkNewCustomer).click();;
			mylog.debug("New Customer Link is clicked");
	}
	
	public void setCustomerName(String custName)
	{
		/*WebDriverWait wait=new WebDriverWait(Driver,20);
		WebElement element=wait.until(ExpectedConditions.visibilityOf((WebElement) txtCustomerName));*/
		Driver.findElement(txtCustomerName).sendKeys(custName);
		mylog.debug("Value "+ custName + "is set to Customer Name");
	}
	
	public void selectSex(String sex)
	{
		if(sex.trim().equals("m"))
		{
			Driver.findElement(By.xpath("//input[contains(@name,'rad1') and contains(@value,'m')]")).click();
			mylog.debug("Value Male is set to Sex");			
			
		}
		else
		{
			Driver.findElement(By.xpath("//input[contains(@name,'rad1') and contains(@value,'f')]")).click();
			mylog.debug("Value Female is set to Sex");
		}
		

	}
	
	public void setDOB(String DOB)
	{
		Driver.findElement(txtDOB).sendKeys(DOB);
		mylog.debug("Value "+ DOB + "is set to DOB");
	}
	
	public void setAddress(String Address)
	{
		Driver.findElement(txtAddress).sendKeys(Address);
		mylog.debug("Value "+ Address + "is set to Address");
		
	}
	
	public void setCity(String City)
	{
		Driver.findElement(txtCity).sendKeys(City);
		mylog.debug("Value "+ City + "is set to City");
	}
	
	public void setState(String State)
	{
		Driver.findElement(txtState).sendKeys(State);
		mylog.debug("Value "+ State + "is set to State");
	}
	
	public void setPinNumber(String PIN)
	{
		Driver.findElement(txtPinNumber).sendKeys(PIN);
		mylog.debug("Value "+ PIN + "is set to PIN");
	}
	
	public void setPhoneNumber(String Phone)
	{
		Driver.findElement(txtPhoneNumber).sendKeys(Phone);
		mylog.debug("Value "+ Phone + "is set to Phone");
	}
	
	public void setEmailId(String emailId)
	{
		Driver.findElement(txtemailId).sendKeys(emailId);
		mylog.debug("Value "+ emailId + "is set to EmailId");
	}
	public void setPassword(String Pwd)
	{
		Driver.findElement(txtPassword).sendKeys(Pwd);
		mylog.debug("Value "+ Pwd + "is set to Password");
	}
	
	public void clickSubmit()
	{
		Driver.findElement(btnSubmit).click();
		mylog.debug("Submit is clicked Successfully");
	}
	public String getCustomerId()
	{
		mylog.debug(" Customer Id " + Driver.findElement(txtCustId).getText());
		return Driver.findElement(txtCustId).getText();
	}	
	public void clickContinue()
	{
		Driver.findElement(lnkContinue).click();
		mylog.debug(" Contine Link is clicked ");
	}	
}