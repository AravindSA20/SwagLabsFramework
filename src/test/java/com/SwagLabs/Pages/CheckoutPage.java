package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	private WebDriver driver;
	
	public CheckoutPage(WebDriver driver) //Base class driver
	{
		this.driver=driver;
	}
	
	//Locators
	private By firstname=By.id("first-name");
	private By lastname=By.id("last-name");
	private By zipcode=By.name("postalCode");
	private By cancelBtn=By.id("cancel");
	private By continueBtn=By.id("continue");
	
	//Methods
	public void doCancel()
	{
		driver.findElement(cancelBtn).click();
		System.out.println("Checkout process cancelled!");
	}
	
	public void doContinue(String fname,String lname,String zc)
	{
		driver.findElement(firstname).sendKeys(fname);
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(zipcode).sendKeys(zc);
		driver.findElement(continueBtn).click();
		System.out.println("Overview Page is opened!");
	}

}
