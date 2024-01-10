package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

import com.SwagLabs.Utitlity.Utility;

import org.testng.annotations.Test;

public class OverviewPageTestcase extends BaseClass //Creating TestNg Class for every Test cases
{
  @Test(priority=1)
  public void verifySummary() 
  {
	  op.getSummary();
	  Utility.getScreenshot(driver);
  }
  
  @Test(priority=2)
  public void verifyOvervuew() 
  {
	  op.doFinish();
	  Utility.getScreenshot(driver);
  }
}
