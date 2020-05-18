package com.practice.testcases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.practice.pageobject.AdminFeatures;
import com.practice.pageobject.Login;

public class TC_Login_001 extends BaseClass
{
	@Test
	public void login() throws IOException
	{
		Login li = new Login(driver);
		logger.info("driver successfully invoked");
		li.getUsernamePath().sendKeys(username);
		logger.info("User name entered");
		li.getPasswordPath().sendKeys(password);
		logger.info("password entered");
		li.getclickBtnPath().click();
		logger.info("Clicked");
		//captureScreenShot(driver,"Login");
		
		
	}
	
	@Test(dependsOnMethods="login")
	public void adminFeature()
	{
		AdminFeatures af = new AdminFeatures(driver);
		af.getClictAdminPath().click();
		logger.info("Clicked the admin feature");
	}
	
}
