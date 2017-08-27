package genericLibrary;

import java.io.File;

public class Testing {
	
	Testing()
	{
		String fname="log4j.properties";
		File file=new File("src/test/java/"+fname);
		System.out.println(file.getAbsolutePath());
	}
	
	public static void main(String args[])
	{
		Testing t=new Testing();
	}
}
