package stepDefinition;

import java.io.IOException;		
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;	

public class AutoIT_Example {				
public static void main(String[] args) throws IOException, InterruptedException {								
	System.setProperty("webdriver.chrome.driver","C:/Users/Raja/Downloads/chromedriver_win32/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
		
    driver.get("http://toolsqa.com/automation-practice-form/");
    Thread.sleep(5000);
    driver.manage().window().maximize();

    //Upload
    
    WebElement browseButton=driver.findElement(By.cssSelector("input.input-file"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", browseButton);
    //browseButton.click();
    Thread.sleep(500); 
    //Runtime.getRuntime().exec("C:\\Raja\\AutoITScripts\\FileUpload_1.exe");
    
    //DownLoad
    WebElement downLoadLink=driver.findElement(By.cssSelector("input.input-file"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downLoadLink);
    downLoadLink.click();
    Thread.sleep(500); 
    Runtime.getRuntime().exec("C:\\Raja\\AutoITScripts\\FileDownLoad_0307.exe");

     }
}