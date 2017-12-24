package genericLibrary;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;

public class Testing {
	
	Testing()
	{
		String fname="log4j.properties";
		File file=new File("src/test/java/resources/"+fname);
		System.out.println(file.getAbsolutePath());
	}
	
	public static void main(String args[]) throws IOException
	{
		//File f=new File("../target");
		System.out.println(FileUtils.fileExists("target1"));
		//f.mkdirs();
		/*System.out.println("99" + FileUtils.fileExists("TestData/TestData_Guru99Bank.xlsx"));
		Testing t=new Testing();
		Runtime.getRuntime().exec("AutoIt_Scripts/FileUpload.exe");*/
	}
}
