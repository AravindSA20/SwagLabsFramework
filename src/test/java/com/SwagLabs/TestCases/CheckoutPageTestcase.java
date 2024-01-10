package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

public class CheckoutPageTestcase extends BaseClass  //Creating TestNg Class for every Test cases
{
  @Test(priority=1)
  public void verifyCancel() 
  {
	  ch.doCancel();
	  addWait();
	  cp.doCheckOut();
  }
  
  @Test(priority=2)
  public void verifyCheckout() 
  {
	  ch.doContinue("Mitzi", "Chan", "600028");
  }
}