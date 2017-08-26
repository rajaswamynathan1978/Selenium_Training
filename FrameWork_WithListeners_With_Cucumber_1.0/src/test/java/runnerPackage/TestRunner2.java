package runnerPackage;

import java.io.File;
import java.net.URL;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


public class TestRunner2 {
	
	public  void display()
	{
		//File f=new File("src/test/java/stepDef/Practice_Automation_ToolsQA_StepDef.java");
		//File f=new File("/../java/stepDef/Practice_Automation_ToolsQA_StepDef.java");
		File f=new File("src/test/java//log4j.properties");
		URL url=getClass().getResource("../log4j.properties");
		File f1=new File(url.getPath());
		System.out.println(f.exists());
		System.out.println(f1.getAbsolutePath());
	}
	
	public static void main(String args[])
	{
		TestRunner2 t=new TestRunner2();
		t.display();
		
	}

}