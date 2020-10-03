package com.orangeHrm.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangeHrm.utils.Constants;
import com.orangeHrm.utils.configReader;

public class BaseClass {
	
public static	ExtentHtmlReporter htmlReport;
public static	ExtentReports report;
public static	ExtentTest test;
//BASE CLASS ----> initializes the driver and quits
	public static WebDriver driver;
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
	
	public static void tearDown() {
		if(driver!=null) {
		driver.quit();
		}
	}
}
