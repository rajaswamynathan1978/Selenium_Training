package genericLibrary;

import java.io.File;
import java.io.IOException;

public class Testing {
	
	Testing()
	{
		String fname="log4j.properties";
		File file=new File("src/test/java/resources/"+fname);
		System.out.println(file.getAbsolutePath());
	}
	
	public static void main(String args[]) throws IOException
	{
		Testing t=new Testing();
		Runtime.getRuntime().exec("AutoIt_Scripts/FileUpload.exe");
	}
}
