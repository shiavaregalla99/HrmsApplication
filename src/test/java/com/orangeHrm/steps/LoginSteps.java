package com.orangeHrm.steps;

import org.testng.Assert;

import com.orangeHrm.testBase.BaseClass;
import com.orangeHrm.testBase.PageInitalizer;
import com.orangeHrm.utils.CommonMethods;
import com.orangeHrm.utils.configReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends PageInitalizer {
	
	@Given("User enters the Login application")
	public void user_enters_the_Login_application() {
	    BaseClass.setUp();
	}

	@When("User enter valid username and valid password")
	public void user_enter_valid_username_and_valid_password() {
		CommonMethods.sendText(login.userName,configReader.getProperty("UserName"));
		CommonMethods.sendText(login.password,configReader.getProperty("Password"));
		
		}

	@When("User click on the login button")
	public void user_click_on_the_login_button() {
		CommonMethods.clickAction(login.buttonLogin);
	}

	@Then("User successfully logged in")
	public void user_successfully_logged_in() {
		String actualText=dashBoard.welcomeText.getText();
		//String expectedText="Welcome Linda";
		//Assert.assertEquals(actualText, expectedText,"actual and expected mismatch");
		
	}
	
	@When("User enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		CommonMethods.sendText(login.userName,username);
		CommonMethods.sendText(login.password,password);
	}

	

	@Then("User should see {string}")
	public void user_should_see(String errormessagetext) {
	String actualText=	login.errorMessage.getText();
	
	Assert.assertEquals(actualText, errormessagetext,"error message does not match");
	BaseClass.tearDown();
	
	}


}
