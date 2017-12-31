package genericLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListener_testNG implements ITestListener
{
	final static Logger mylog = Logger.getLogger("abc");

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

	//This method is used to take Screen Shot for Failures
	public void onTestFailure(ITestResult result) 
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss_a");
		mylog.info(String.format("From Listener Class -- > Method %s is Failed From Test %s",result.getName(),result.getName()));
		captureScreenShot.captureScreenShot_(result.getName().toString().trim()+"_"+sdf.format(date).toString());
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
