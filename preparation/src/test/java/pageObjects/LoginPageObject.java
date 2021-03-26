package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	WebDriver lDriver;
	public LoginPageObject(WebDriver rDriver) {
		this.lDriver=rDriver;
		PageFactory.initElements(lDriver,this);
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	public void setUserName(String inputValue)
	{
		try
		{
		txtUserName.sendKeys(inputValue);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void setPassword(String inputValue)
	{
		txtPassword.sendKeys(inputValue);
		
	}
	
	

}
