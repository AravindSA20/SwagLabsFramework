package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  //Creating java class without main() function
{
	
	//Encapsulation = data(private) + method(public)
	
	private WebDriver driver;
	
	//Initialization of driver
	public LoginPage(WebDriver driver)  //Base class - No void 
	{
		this.driver=driver;
	}
	
	//Locators
	private By username=By.id("user-name");
	private By password=By.id("password");
	private By loginbtn=By.name("login-button");
	
	
	//Methods
	public String getUrl()
	{
	   return driver.getCurrentUrl();	
	}
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	
	public String doLogin(String user, String pwd)
	{
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbtn).click();
		String cUrl=driver.getCurrentUrl();
		return cUrl;                                  //To validate current URL
	}
}
