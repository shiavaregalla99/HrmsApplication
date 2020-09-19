package com.orangeHrm.utils;

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
}
