package com.oragneHrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.testBase.BaseClass;
import com.orangeHrm.utils.CommonMethods;

public class LoginPage extends CommonMethods {
	//page object model----> it is design pattern
	//page object model without page factory
 // public WebElement userName=      driver.findElement(By.id("txtUsername"));
 // public WebElement passWord=      driver.findElement(By.id("txtPassword"));
//  public WebElement buttonLogin=   driver.findElement(By.id("btnLogin"));
  //page object model with page factory
  //using the page Factory we are going to use the @FindBy Annotation
  @FindBy(id="txtUsername")
  public WebElement userName;
  @FindBy(id="txtPassword")
  public WebElement password;
   @FindBy(id="btnLogin")
  public WebElement buttonLogin;
   @FindBy(xpath="//span[@id='spanMessage']")
   public WebElement errorMessage;
   public LoginPage() {
	  PageFactory.initElements(BaseClass.driver, this); 
   }
   

}
