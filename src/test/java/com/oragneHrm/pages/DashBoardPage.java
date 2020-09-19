package com.oragneHrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.testBase.BaseClass;

public class DashBoardPage {

	 @FindBy(xpath="//a[@id='welcome']")
	  public WebElement welcomeText;
	   public DashBoardPage() {
		  PageFactory.initElements(BaseClass.driver, this); 
	   }
	   

}
