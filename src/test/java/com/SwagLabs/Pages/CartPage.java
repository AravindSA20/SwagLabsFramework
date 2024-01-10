package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage 
{
	private WebDriver driver;
	
	public CartPage(WebDriver driver) //From Base class
	{
		this.driver=driver;
	}
	
	//Locators
	private By cartPage=By.xpath("//a[@class='shopping_cart_link']");
	private By removeBtn=By.xpath("//button[text()='Remove']");
	private By continueBtn=By.xpath("//button[text()='Continue Shopping']");
	private By checkoutBtn=By.id("checkout");
	
	//Methods
	public void getCartPage()
	{
		driver.findElement(cartPage).click();
		System.out.println("Cart page is open!");
	}
	
	public void doRemove()
	{
		driver.findElement(removeBtn).click();
		System.out.println("Selected Product get removed!");
	}
	
	public void doContinueShopping()
	{
		driver.findElement(continueBtn).click();
		System.out.println("Inventory Page will open: Select a Product!");
	}

	public String doCheckOut()
	{
		driver.findElement(checkoutBtn).click();
		return driver.getCurrentUrl();
	}
}
