package stepDefinition;

 
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
 
public class FluentWaitDemo {
 
public static void main(String[] args) throws InterruptedException {
 
	System.setProperty("webdriver.chrome.driver","C:/Users/Raja/Downloads/chromedriver_win32/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
    driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
 //xpath=//button [text()='Click me to start timer']
    	  // Create object of FluentWait class and pass webdriver as input
          FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
 
          // Set poll for very single second
          wait.pollingEvery(1, TimeUnit.SECONDS);

          // Max time for wait- If conditions are not met within this time frame then it will fail the script
          wait.withTimeout(10, TimeUnit.SECONDS);
 
          // we are creating Function here which accept webdriver and output as WebElement-
 
          try
          {
          WebElement element = wait.until(
        		  new Function<WebDriver, WebElement>()
        		  {
		                // apply method- which accept webdriver as input
		                public WebElement apply(WebDriver arg0) 
			               	{
			            	   // find the element
			            	   	WebElement ObjElement = arg0.findElement(By.xpath("//p[@id='demo']"));
			            	   	// Will capture the inner Text and will compare will WebDriver
			            	   	// If condition is true then it will return the element and wait will be over
			                     if (ObjElement.getAttribute("innerHTML").equalsIgnoreCase("abcdef")) 
			                      {
			                          System.out.println("Value is >>> " + ObjElement.getAttribute("innerHTML"));
			                          return ObjElement;
			                     }
			                     // If condition is not true then it will return null and it will keep checking until condition is not true
			                     else {
			                    	 	System.out.println("Value is >>> " + ObjElement.getAttribute("innerHTML"));
			                    	 	return null;
			                     	  }
			               }
          });
          
          System.out.println("Final visible status is >>>>> " + element.isDisplayed());
          driver.close();
          }
          catch(Exception e)
          {
        	  System.out.println(e.getMessage());
        	  System.out.println("null is returned");
          }

          
          // If element is found then it will display the status
          
     }
}