package tests;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;

public class LoginTest extends BaseClass {
	
	WebDriver localDriver;
	
	private LoginPageObject loginPageObject;
	
	@Parameters("browser")
	@Test
	public void performLogin(String browser)
	{
		
		/*localDriver=getBrowser(browser);
		localDriver.get("http://demo.guru99.com/v4/");
		loginPageObject=new LoginPageObject(localDriver);
		loginPageObject.setUserName("Hello");
		loginPageObject.setPassword("Password");*/
		
		//wd.get("http://demo.guru99.com/v4/");
		loginPageObject=new LoginPageObject(wd);
		loginPageObject.setUserName("Hello");
		loginPageObject.setPassword("Password");
		
	}

}
