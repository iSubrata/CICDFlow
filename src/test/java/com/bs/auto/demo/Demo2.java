package com.bs.auto.demo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo2 {
 WebDriver driver ;
  @Test
  public void method2() {
	  	 String baseUrl = "http://demo.testfire.net/";
	
	      System.out.println("Triggering Demo2 method2"); 
	      //driver = new ChromeDriver();
	      driver.get(baseUrl);
	      String testTitle = "Altoro Mutual";
	      String originalTitle = driver.getTitle();
	      Assert.assertEquals(originalTitle, testTitle);
  }
  
  @BeforeMethod
  @Parameters(value={"browser","version","platform"})
  public void setUp(String browser, String version, String platform) throws Exception {
	
	  String strCurrentPath = System.getProperty("user.dir");
	  String strPathSeperator = File.separator;
	  String strBrowserDriverPath = new StringBuilder(strCurrentPath).append(strPathSeperator).append("src").append(strPathSeperator).append("test").append(strPathSeperator).append("resources").append(strPathSeperator).append("BrowserDriver").append(strPathSeperator).toString();
	  String strChromeDriverPath = new StringBuilder(strBrowserDriverPath).append("chromedriver.exe").toString();
	  String strFFDriverPath = new StringBuilder(strBrowserDriverPath).append("geckodriver.exe").toString();
 
	  if(browser.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver", strChromeDriverPath);
		  driver = new ChromeDriver();
		  System.out.println("Starting Test On Chrome Browser for Demo2");
	  }else {
		  System.setProperty("webdriver.gecko.driver", strFFDriverPath);
		  driver = new FirefoxDriver();
		  System.out.println("Starting Test On FireFox Browser for Demo2");
	  }

  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  System.out.println("Finished Test for Demo2");
  }
  
 
}

//============================BELOW TO FOLLOW IF BROWSER STACK/SAUCE LAB/LAMDA TEST====================
/*	 
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("browserName", browser);
capabilities.setCapability("version", version);
capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any available one
capabilities.setCapability("build", "ParallelTestNG");
capabilities.setCapability("name", "ParallelTestNG");
capabilities.setCapability("network", true); // To enable network logs
capabilities.setCapability("visual", true); // To enable step by step screenshot
capabilities.setCapability("video", true); // To enable video recording
capabilities.setCapability("console", true); // To capture console logs
/*
try {
    //driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	 driver = new ChromeDriver();
} catch (Exception e) {
    System.out.println(e.getMessage());
}
*/
