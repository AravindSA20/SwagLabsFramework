package com.SwagLabs.Utitlity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	// Reusable Script/Method 
	
	//Select
	public static void selectBasedDropdown(WebElement ele, String value) {
		Select dd = new Select(ele);
		System.out.println("Is Day dropdown selects multiple selection? :" + dd.isMultiple());

		List<WebElement> allOptions = dd.getOptions();
		System.out.println("Total Options are: " + allOptions.size());
		for (WebElement i : allOptions) {
			System.out.println(i.getText());
			if (i.getText().contains(value)) {
				i.click();
				break;
			}
		}
	}
	
	//For Goibibo From To
	public static void gobibo(WebDriver driver, String loc) {
		List<WebElement> fromList = driver
				.findElements(By.xpath("//ul[@class='sc-12foipm-40 gqpBlv']//span[@class='autoCompleteTitle ']"));
		System.out.println("Total Options are: " + fromList.size());
		for (WebElement i : fromList) {
			System.out.println(i.getText());
			if (i.getText().contains(loc)) {
				i.click();
				break;
			}
		}
	}
	
	
	
	//Explicit Wait Reusable methods
	public static WebElement waitForPrecenceofElement(WebDriver driver,By loc)   //Instead of void, we used WebElement to return the obj
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(5));
		return obj.until(ExpectedConditions.presenceOfElementLocated(loc)); //return type is used instad of WebElement ele=obj
	}
	
	public static WebElement waitForElementClickable(WebDriver driver,By loc) 
	{
		WebDriverWait btnobj=new WebDriverWait(driver,Duration.ofSeconds(5));
        return btnobj.until(ExpectedConditions.elementToBeClickable(loc));	
	}
	
	public static WebElement waitForVisiblityofElement(WebDriver driver,By loc)   
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(5));
		return obj.until(ExpectedConditions.visibilityOfElementLocated(loc)); 
	}
	
	public static boolean waitForUrlContains(WebDriver driver,String url)  //Boolean is used to return 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.urlContains(url));
	}
	
	public static boolean waitForTitleContains(WebDriver driver,String title)  //Boolean is used to return 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains(title));
	}

	
	//JavascriptExecutor- Scroll
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.scrollHeight)");
	}
	
	public static void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.scrollHeight,0)");
	}
	
	public static void scrollToElement(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView()",ele);
	}
	
	//Screenshot
	public static void getScreenshot(WebDriver driver)
	{
		  TakesScreenshot ts=(TakesScreenshot) driver; //add type casting
		  File temp=ts.getScreenshotAs(OutputType.FILE);
		  
		  //Location
		  File dest=new File("./"+"\\Screenshots\\SwagLabs"+System.currentTimeMillis()+".png");
		  
		  try {                   
			FileHandler.copy(temp,dest);   //Surround with try-catch
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	}

}
