package pages_Repository;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Repo {
	
	public WebDriver driver;
	By userId=By.name("UserName");
	By password=By.name("Password");
	By btnSubmit =By.cssSelector("input[name=Login]");
	//By btnSubmit=By.name("Login");
	
	
	
	final static Logger mylog = Logger.getLogger("abc");
	
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
	
	public void clickSubmit() throws InterruptedException
	
	{
		Thread.sleep(1000);
		driver.findElement(btnSubmit).click();
		mylog.info("Submit is clicked");
	}

}
