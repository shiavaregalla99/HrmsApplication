package com.orangeHrm.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangeHrm.utils.Constants;
import com.orangeHrm.utils.configReader;

public class BaseClass {
//BASE CLASS ----> initializes the driver and quits
	public static WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public static WebDriver setUp() {
		configReader.readProperties(Constants.CONFIGURATION_PATH);	
   
		 switch(configReader.getProperty("BrowserName")) {
		 case "chrome":
			 System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			 driver= new ChromeDriver();
			 break;
		 case "firefox":
			 System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_PATH);
	         driver= new InternetExplorerDriver();
	         break;
	         
		 case "ie":
			 System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_PATH);
	         driver= new InternetExplorerDriver();
	         break;
	         
	         default:
	        	 throw new RuntimeException("Browser is not supported");
		 
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.get(configReader.getProperty("URL"));
		 PageInitalizer.intialize();
		  return driver;
		
	}
	@AfterMethod(alwaysRun=true)
	public static void tearDown() {
		if(driver!=null) {
		driver.quit();
		}
	}
}
