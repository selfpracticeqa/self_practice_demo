package com.practice.testcases;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practice.pageobject.Login;
import com.practice.utilities.XlUtilities;

public class TC_Login_DataDriven_003 extends BaseClass 
{

	@Test(dataProvider="loginData")
	public void DataDrivenLogin(String username, String password) throws InterruptedException, IOException
	{
		Login li = new Login(driver);
		logger.info("Browser invoked");
		li.getUsernamePath().sendKeys(username);
		logger.info("username entered");
		li.getPasswordPath().sendKeys(password);
		logger.info("Password entered");
		li.getclickBtnPath().click();
		logger.error("Clicked");
		Thread.sleep(2000);
		if(loginFailed()==true)
		{
			//captureScreenShot(driver,"Login");
			Assert.assertFalse(false);
			logger.info("Login Failed");
			
		}
		else
		{
			System.out.println(driver.getTitle());
			Assert.assertTrue(true);
			logger.info("Login Successsful");
			
			driver.navigate().back();
			
			logger.info("Navigated back to login page");
		}
		
	}
	
	public boolean loginFailed()
	{
		try
		{
		driver.findElement(By.cssSelector("[id='spanMessage']")).isDisplayed();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="loginData")
	public String[][] dataProvider() throws IOException
	{
		String testData = System.getProperty("user.dir")+"/src/test/java/com/practice/testdata/data.xlsx";
		XlUtilities xl = new XlUtilities();
		int noOfRow = xl.getRowCount(testData, "Sheet1");
		int noOfColumn = xl.getColumnCount(testData, "Sheet1", 1);
		
		String loginData[][] = new String[noOfRow][noOfColumn];
		
		for(int i=1;i<=noOfRow;i++)
		{
			for(int j=0;j<noOfColumn;j++)
			{
				loginData[i-1][j]=xl.getCellData(testData, "Sheet1" , i, j);
			}
		}
		return loginData;
	}
	
}
