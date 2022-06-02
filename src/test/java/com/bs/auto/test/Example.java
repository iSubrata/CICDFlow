package com.bs.auto.test;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example {
	WebDriver driver ;
	  @Test
	  public void method2() {
		  	 String baseUrl = "https://demo.testfire.net/";
		
		      System.out.println("Triggering Example method2"); 
		      //driver = new ChromeDriver();
		      driver.get(baseUrl);
		      String testTitle = "Altoro Mutual";
		      String originalTitle = driver.getTitle();
		      Assert.assertEquals(originalTitle, testTitle);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
		  System.out.println("Finished Test for Example");
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  String strCurrentPath = System.getProperty("user.dir");
		  String strPathSeperator = File.separator;
		  String strBrowserDriverPath = new StringBuilder(strCurrentPath).append(strPathSeperator).append("src").append(strPathSeperator).append("test").append(strPathSeperator).append("resources").append(strPathSeperator).append("BrowserDriver").append(strPathSeperator).append("geckodriver.exe").toString();
		//Setting system properties of ChromeDriver 
		  //System.setProperty("webdriver.chrome.driver", strBrowserDriverPath);
		  System.setProperty("webdriver.gecko.driver", strBrowserDriverPath);
		  driver = new  FirefoxDriver();
		  System.out.println("Starting Test On Firefox Browser for Example");
	  }
	

	}
