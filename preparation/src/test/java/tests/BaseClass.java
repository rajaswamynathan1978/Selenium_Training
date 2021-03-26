package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver wd;
	/*
	 * @Parameters("browser") public WebDriver getBrowser(String browser) {
	 * if(wd==null) { if(browser.equalsIgnoreCase("chrome")) {
	 * System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe"
	 * ); wd=new ChromeDriver(); } } return wd; }
	 */

	@BeforeClass
	@Parameters("browser")
	public void getBrowser(String browser) {
		System.out.println("I am running now");
		if (wd == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				wd = new ChromeDriver();
				wd.get("http://demo.guru99.com/v4/");
			}
		}
	}

}
