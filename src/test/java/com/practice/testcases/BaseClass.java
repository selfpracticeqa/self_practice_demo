package com.practice.testcases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.practice.utilities.ReadUtilities;

public class BaseClass 
{
	ReadUtilities ru = new ReadUtilities();
	String url = ru.getUrl();
	String username = ru.getUsername();
	String password = ru.getPassword();
	public Logger logger;
	
	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger("Practice");
		
		if(browser.equals("chromePath")) {
		System.setProperty("webdriver.chrome.driver", ru.getChromeDriver());
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ru.getFireFoxDriver());
			driver= new FirefoxDriver();
		}
		else if(browser.equals("IE")) {
			System.setProperty("webdriver.IE.driver", ru.getIEDriver());
			driver= new InternetExplorerDriver();
		}
		else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", ru.getEdgeDriver());
			driver =new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);

		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp

		String destinationFile = System.getProperty("user.dir")+"\\screenshots\\"+testCaseName+"-"+timeStamp+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
	
	
}
