package stepDefinition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaBasics {
	
	public void testing()
	{
		//System.out.println("Testing");
	}
	
	public void mapExample()
	{
		HashMap<String,String> myMap=new HashMap<String,String>();
		
		myMap.put("Telengana","Hyderabad");
		myMap.put("Andhra","SomeCapital");
		myMap.put("TamilNadu","Chennai");
		myMap.put("Kerala","Trivandrum");
		myMap.put("Kera","qqq");
		myMap.put("Kera1","ccc");
		
		
		Set mySet=myMap.entrySet();
		
		Iterator myIterator=mySet.iterator(); 
		
		while(myIterator.hasNext())
		{
			Map.Entry<String,String> m1=(Entry<String, String>) myIterator.next();
			
			System.out.println("My Key is " + m1.getKey() +" --> And My Value is :" +  m1.getValue());
		}
		
		
		
	}
	
	
	
	public static void main(String args[])
	{
	try
		{
		JavaBasics obj=new JavaBasics();
		obj.mapExample();
		System.exit(0);
		obj.testing();
		
		File myFile=new File("C:/Raja/TestFile.txt");
		
		if(!(myFile.exists()))
				{
					FileWriter fw=new FileWriter(myFile);
					BufferedWriter bw=new BufferedWriter(fw);
					
					bw.write("This is Selenium Tranining Session 1\n");
					bw.write("This is Selenium Tranining Session 2\n");
					bw.write("This is Selenium Tranining Session 3");
					
					bw.flush();
					bw.close();
					
					bw=null;
					fw=null;
					myFile=null;
				}
		
		else
		{
			
			FileWriter fw=new FileWriter(myFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			
			bw.write("\nThis is Selenium Tranining Session 11\n");
			bw.write("This is Selenium Tranining Session 12\n");
			bw.write("This is Selenium Tranining Session 13");
			
			bw.flush();
			bw.close();
			
			bw=null;
			fw=null;
			myFile=null;
			
			
			
			/*FileReader fr=new FileReader(myFile);
			BufferedReader br=new BufferedReader(fr);
			
			String info="";
			
			while((info=br.readLine())!=null)
			{
				System.out.println("Info From File :"+ info);
			}
			
			br.close();
			br=null;
			fr=null;
			myFile=null;*/
		}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
