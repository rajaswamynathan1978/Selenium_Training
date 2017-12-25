package genericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.events.WebDriverEventListener;
public class EventListener_testNG implements ITestListener
{
	final static Logger mylog = Logger.getLogger("appLog");
	
	public void onTestStart(ITestResult result) 
	{
		mylog.info(String.format("Method %s is Passed From Test %s",result.getName(),result.getName()));
		//System.out.println((String.format("Method %s is Passed From Test %s",result.getName(),result.getTestName())));		
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		mylog.info(String.format("Method %s is Passed From Test %s",result.getName(),result.getName()));
		//System.out.println(String.format("Method %s is Passed From Test %s",result.getName(),result.getTestName()));
	}

	public void onTestFailure(ITestResult result) 
	{
		mylog.info(String.format("Method %s is Failed From Test %s",result.getName(),result.getName()));
		//System.out.println(String.format("Method %s is Failed From Test %s",result.getName(),result.getTestName()));
	}

	public void onTestSkipped(ITestResult result) 
	{
		mylog.info(String.format("Method %s is Skipped From Test %s",result.getName(),result.getName()));
		//System.out.println((String.format("Method %s is Skipped From Test %s",result.getName(),result.getTestName())));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{
		mylog.info(String.format("Method %s is Started",context.getName()));	
		//System.out.println(String.format("Method %s is Started",context.getName()));
	}

	public void onFinish(ITestContext context) 
	{
		mylog.info(String.format("Method %s is Finished",context.getName()));	
		//System.out.println(String.format("Method %s is Finished",context.getName()));
		
	}
	
	

}
