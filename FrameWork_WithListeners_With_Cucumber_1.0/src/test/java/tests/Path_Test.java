package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class Path_Test {
	
	public void displayPath() throws IOException
	{
		File f=new File("src/test/java/tests/log4j.properties");
		
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String s="";
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
		}
		
		
	}
	
	public static void main(String args[]) throws IOException
	{
		Path_Test p=new Path_Test();
		p.displayPath();
	}

}
