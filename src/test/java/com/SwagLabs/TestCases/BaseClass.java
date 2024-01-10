package com.SwagLabs.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
// Using * to import all annotations
import org.testng.annotations.BeforeTest;

// Adding * so that every pages will be imported
import com.SwagLabs.Pages.CartPage;
import com.SwagLabs.Pages.CheckoutPage;
import com.SwagLabs.Pages.InventoryPage;
import com.SwagLabs.Pages.LoginPage;
import com.SwagLabs.Pages.OverviewPage;
import com.SwagLabs.Utitlity.PropertiesUtil;
import com.SwagLabs.Utitlity.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass //Creating normal java class without main() function
{
	public WebDriver driver;
	public LoginPage lp;  //Creating object of the LoginPage class
	public InventoryPage ip; //Creating object of the InventoryPage class
	public CartPage cp;   //Creating object of the CartPage class
	public CheckoutPage ch;  //Creating object of the CheckoutPage class
	public OverviewPage op; //Creating object of the OverviewPage class
	public PropertiesUtil p1; //Creating object of the PropertiesUtil class
	
	//For Reports
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@BeforeSuite
	public void reports()
	{
		//Create ExtentReport instance
		  extent=new ExtentReports();
		  
		  //Using reporter we can add path  - it will create folder automatically
		  spark = new ExtentSparkReporter("Reports/Swaglabs.html");
		  
		  //setup any configuration
		  spark.config().setDocumentTitle("Sprint1 report");
		  spark.config().setReportName("SwagLabAutomation Testing Report");
		  spark.config().setTheme(Theme.DARK);
		  
		  //attach the report
		  extent.attachReporter(spark);
		  
		  //Create a test - ExtentTest
		  test=extent.createTest("SwagLaabs End-End Report");
	}
	
	@BeforeTest  //For all Pages , Browser Setup
	public void setupBrowser()
	{
		p1=new PropertiesUtil();  //Before driver, PropertiesUtil object should be declared
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p1.getData("url"));
		test.pass("SwagLabs Application is opened successfully!");
		
		lp=new LoginPage(driver); //Initializing the object lp
		ip=new InventoryPage(driver);
		cp=new CartPage(driver);
		ch=new CheckoutPage(driver);
		op=new OverviewPage(driver);
		
	}
	
	@BeforeClass   //User must be login first, which is Page Pre-conditions
	public void pageSetUp()
	{
		System.out.println("********Login Page********");
		System.out.println("URL is: "+lp.getUrl());
		System.out.println("Title is: "+lp.getAppTitle());
		Utility.getScreenshot(driver);
		lp.doLogin(p1.getData("un"), p1.getData("pwd"));
		test.pass("Login is completed!");
		addWait();
		Utility.getScreenshot(driver);
		
		System.out.println("********Inventory Page********");
		System.out.println("Total Product Count is : "+ip.getProductCount());
		ip.getProductName();
		addWait();
		Utility.getScreenshot(driver);
		ip.addToCart(p1.getData("pname1"));
		addWait();
		Utility.getScreenshot(driver);
		cp.getCartPage();
		addWait();
		Utility.getScreenshot(driver);
		test.pass("Inventory page validation is completed!");
		
		System.out.println("********Cart Page********");
		cp.doRemove();
		addWait();
		Utility.getScreenshot(driver);
		cp.doContinueShopping();
		ip.addToCart(p1.getData("pname2"));
		cp.getCartPage();
		addWait();
		Utility.getScreenshot(driver);
		cp.doCheckOut();
		Utility.getScreenshot(driver);
		test.pass("Cart page validation is completed!");
		
		System.out.println("********Checkout Page********");
		ch.doContinue(p1.getData("fn"), p1.getData("ln"), p1.getData("zc"));
		test.pass("Checkout page validation is completed!");
		
		System.out.println("********Overview Page********");
		test.pass("Overview page validation is completed!");
	}

	public void addWait()   
	{
		try {
			Thread.sleep(2000);  //Surround by Try-Catch
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void exitReport()
	{
		extent.flush();
	}
}
