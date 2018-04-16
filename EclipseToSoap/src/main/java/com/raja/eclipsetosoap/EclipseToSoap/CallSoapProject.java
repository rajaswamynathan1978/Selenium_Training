package com.raja.eclipsetosoap.EclipseToSoap;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.SoapUIException;

public class CallSoapProject {
	
	public static void main(String args[]) throws XmlException, IOException, SoapUIException
	{
		WsdlProject project = new WsdlProject ("D:/Soap_Project/Calculator-soapui-project.xml");
		System.out.println(project.getTestSuiteCount());
		
		for(int i=0;i<project.getTestSuiteCount();i++)
		{
			System.out.println(project.getTestSuiteAt(i).getName());
			
			for (String ite1 : project.getTestSuiteAt(i).getPropertyNames())
				System.out.println(ite1.toString() +","+ project.getTestSuiteAt(i).getProperty(ite1.toString()).getValue());
				
			}
			
		}

}