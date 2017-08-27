package pages_Repository;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Repo {
	
	WebDriver driver;
	By userId=By.name("uid");
	By password=By.name("password");
	By btnSubmit=By.name("btnLogin");
	
	final static Logger mylog = Logger.getLogger("appLog");
	
	public Login_Repo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setUserName(String UserName)
	
	{
		driver.findElement(userId).sendKeys(UserName);
		mylog.info(UserName + " is entered");

	}
	
	public void setPassword(String Password)
	
	{
		driver.findElement(password).sendKeys(Password);
		mylog.info(Password + " is entered");		
	}
	
	public void clickSubmit()
	
	{
		driver.findElement(btnSubmit).click();
		mylog.info("Submit is clicked");
	}

}
