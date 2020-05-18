package com.practice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminFeatures 
{
	WebDriver driver;
	public AdminFeatures(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By clickAdminPath = By.id("menu_admin_viewAdminModule");
	
	
	
	public WebElement getClictAdminPath()
	{
		return driver.findElement(clickAdminPath);
	}
			

}
