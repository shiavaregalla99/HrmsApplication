package com.orangeHrm.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.orangeHrm.testBase.PageInitalizer;

public class CommonMethods extends PageInitalizer{

	public static void sendText(WebElement ele,String text) {
		ele.sendKeys(text);
	}
	
	public static void clickAction(WebElement ele) {
		ele.click();
	}
	
	public static void wait(int value ) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String takeScreenShot(String fileName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
String destinationFile=Constants.SCREENSHOTS_PATH+fileName+getTimeStamp()+".png";
		try {
			FileUtils.copyFile(file,new File(destinationFile));
		} catch (IOException e) {
			System.out.println("not able to take screen shot ");
			e.printStackTrace();
		}
		return destinationFile;
		
	}
	
	public static String getTimeStamp() {
		Date date= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}
}
