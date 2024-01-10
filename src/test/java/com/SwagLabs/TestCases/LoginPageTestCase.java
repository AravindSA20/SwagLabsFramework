package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTestCase extends BaseClass //Creating TestNg Class for every Test cases and extending with BaseClass
{
  @Test(priority=1)
  public void verifyUrl()
  {
	  String cUrl=lp.getUrl();
	  Assert.assertTrue(cUrl.contains("demo"), "Fail: URL is not matched");
	  System.out.println("URL is matched");
  }
  
  @Test(priority=2)
  public void verifyTitle()
  {
	  String title=lp.getAppTitle();
	  Assert.assertTrue(title.contains("Swag"), "Fail: Title is not matched");
	  System.out.println("Title is matched");
  }
  
  @Test(priority=3)
  public void verifyLogin()
  {
	  String cUrl=lp.doLogin("standard_user", "secret_sauce");
	  Assert.assertTrue(cUrl.contains("inventory"),"Login Failed: Inventory page is not openend!");
	  System.out.println("Login Successful: Inventory page is openend!");
  }
}
