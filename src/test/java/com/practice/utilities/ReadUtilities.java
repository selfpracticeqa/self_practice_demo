package com.practice.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadUtilities 
{
	Properties pro;
	public ReadUtilities()
	{
		File src = new File("./configuration\\config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.print("Exception is: "+e.getMessage());
		}
	}
	
	public String getUrl()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		return pro.getProperty("userName");
	}
	
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	
	public String getChromeDriver()
	{
		return pro.getProperty("chromePath");
	}
	public String getFireFoxDriver() {
		return pro.getProperty("firefox");
	}
	public String getIEDriver() {
		return pro.getProperty("IE");
	}
	public String getEdgeDriver() {
		return pro.getProperty("edge");
	}
	
}
