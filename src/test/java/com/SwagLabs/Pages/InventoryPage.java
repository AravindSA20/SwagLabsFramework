package com.SwagLabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage
{
	private WebDriver driver;
	
	public InventoryPage(WebDriver driver)  // Base class driver
	{
		this.driver=driver;	
	}

	//Locator
	private By prdctList=By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']");
	private By prdtnameList=By.xpath("//div[@class='inventory_item_name ']");
	private By addtocartBtn=By.xpath("//button[text()='Add to cart']");
	
	//Methods
	public int getProductCount()
	{
		int count=driver.findElements(prdctList).size();
		return count;
	}
	
	public void getProductName()
	{
		List<WebElement> pname=driver.findElements(prdtnameList);
		System.out.println("------Product Names are: -------");
		for(WebElement i:pname)
		{
			System.out.println(i.getText());
		}
	}
	
	public void addToCart(String pname)
	{
		List<WebElement> allProduct=driver.findElements(prdtnameList);
		for(WebElement i:allProduct)
		{
			if(i.getText().contains(pname))
			{
				i.click();
				break;
			}
		}
		//add the product
		driver.findElement(addtocartBtn).click();
		System.out.println("Product added into the Cart: "+pname);
	}
	
}
