package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstProgram {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public FirstProgram()
	{
		System.out.println("No arguments");
	}
	
	public FirstProgram(String firstName)
	{
		System.out.println(firstName);
	}
	
	public FirstProgram(String firstName,String lastName)
	{
		System.out.println(firstName+lastName);
	}
	

	public void printName()
	{
		System.out.println("I am not a constructor");
	}
	
	public int printName_ReturnValue()
	{
		return(5);
	}
	
	
	public void alertHandlingAndSnapShot() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/Raja/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
        
        // Alert Message handling
                    		
        driver.get("http://demo.guru99.com/test/delete_customer.php");			
                            		
     	      	
        driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(5000);
        		
        // Accepting alert		
        //alert.accept();
        alert.dismiss();
        
        //Taking Screen Shot
        
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:/Raja/Selenium-Training_Online/Three.png");
        FileUtils.copyFile(SrcFile, DestFile);
	}
	
	
	
	public static void main(String args[]) throws IOException, InterruptedException
	{
		try
		{
		
		FirstProgram Object=new FirstProgram();
		
		//Object.alertHandlingAndSnapShot();
		//System.exit(0);
		int result=Object.printName_ReturnValue();
		System.out.println(result);
		System.out.println("From SystemOutPrintln Command " + Object.printName_ReturnValue());
		
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		//log4j config file path

		File file = new File(prop.getProperty("Edge_Driver"));
		System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
		
		
		driver = new EdgeDriver();
		
		driver.navigate().to("www.facebook.com");
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		// Wait till the element is not visible
		 
		WebElement Web_element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
		
		if (Web_element.isDisplayed())
		{
			System.out.println("FirstName text box is present");
			driver.findElement(By.name("firstname1")).sendKeys("Selenium");
			driver.findElement(By.name("reg_email__")).sendKeys("6263487548");
		}
		else
			System.out.println("FirstName text box is not present");
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		finally
		{
			driver.close();
		}

	}

}
