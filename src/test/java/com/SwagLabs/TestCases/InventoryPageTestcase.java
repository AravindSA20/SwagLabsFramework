package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InventoryPageTestcase extends BaseClass  //Creating TestNg Class for every Test cases and extend with BaseClass
{

  @Test(priority=1)
  public void verifyProductCount() 
  {
	  int count=ip.getProductCount();
	  Assert.assertEquals(count, 6,"Product count is not matched!");  //Where 6 is the number of products expected in a page
	  System.out.println("Product count is as expected!");
	  System.out.println("Total Products are: "+count);
  }
  
  @Test(priority=2)
  public void verifyProductname() 
  {
	  ip.getProductName();
  }
  
  @Test(priority=3)
  public void verifyAddToCart() 
  {
	  ip.addToCart("Sauce Labs Fleece Jacket");
  }
}
