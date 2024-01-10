package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTestcase extends BaseClass  //Creating TestNg Class for every Test cases
{
  @Test(priority=1)
  public void verifyRemove() 
  {
	  cp.doRemove();
	  addWait();
  }
  
  @Test(priority=2)
  public void verifyContinueShopping() 
  {
	  cp.doContinueShopping();
	  addWait();
	  ip.addToCart("Sauce Labs Fleece Jacket"); //inventory page to select a product
	  cp.getCartPage();
	  addWait();
	
  }
  
  @Test(priority=3)
  public void verifyCheckout() 
  {
	  String url=cp.doCheckOut();
	  Assert.assertTrue(url.contains("checkout"),"URL is not matched");
	  System.out.println("Checkout Page is Opened!");
	  
  }
}
