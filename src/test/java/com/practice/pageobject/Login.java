package com.practice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login 
{
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By usernamePath = By.id("txtUsername");
	By passwordPath = By.id("txtPassword");
	By clickBtnPath = By.id("btnLogin");
	By invalidCredential = By.cssSelector("[id='spanMessage']");
	
	
	public WebElement getUsernamePath()
	{
		return driver.findElement(usernamePath);
	}
	
	public WebElement getPasswordPath()
	{
		return driver.findElement(passwordPath);
	}
	
	public WebElement getclickBtnPath()
	{
		return driver.findElement(clickBtnPath);
	}
	
	public WebElement getInvalidCredentialText()
	{
		return driver.findElement(invalidCredential);
	}
}
