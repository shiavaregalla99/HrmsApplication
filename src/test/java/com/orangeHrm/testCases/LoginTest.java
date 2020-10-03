package com.orangeHrm.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oragneHrm.pages.DashBoardPage;
import com.oragneHrm.pages.LoginPage;
import com.orangeHrm.testBase.BaseClass;
import com.orangeHrm.testBase.PageInitalizer;
import com.orangeHrm.utils.CommonMethods;
import com.orangeHrm.utils.Constants;
import com.orangeHrm.utils.ExcelUtility;
import com.orangeHrm.utils.configReader;

public class LoginTest extends CommonMethods {

	
	@Test(groups="smoke")
	public void loginWithValidCredentails()  {
		
		CommonMethods.sendText(login.userName,configReader.getProperty("UserName"));
		CommonMethods.sendText(login.password,configReader.getProperty("Password"));
		CommonMethods.clickAction(login.buttonLogin);

		String actualText=dashBoard.welcomeText.getText();
		String expectedText="Welcome Linda";
		Assert.assertEquals(actualText, expectedText,"actual and expected mismatch");
		
	}
	@Test(priority=2,groups="sanity")
	public void invalidPasswordLogin() {
		
		
		CommonMethods.sendText(login.userName,configReader.getProperty("UserName"));
		CommonMethods.sendText(login.password,configReader.getProperty("InvalidPassword"));
		CommonMethods.clickAction(login.buttonLogin);
		String acutalErrorMessage=login.errorMessage.getText();
		System.out.println(acutalErrorMessage);
		String expectedErrorMessage="Invalid credentials";
		Assert.assertEquals(acutalErrorMessage, expectedErrorMessage);
		

	}
	
	@Test(priority=3,groups="regression",dataProvider="userDataFromExcel")
	public void invalidTestData(String UserName,String Password,String errorMessage) {
		
		
		CommonMethods.sendText(login.userName,UserName);
		CommonMethods.sendText(login.password,Password);
		CommonMethods.clickAction(login.buttonLogin);
		String acutalErrorMessage=login.errorMessage.getText();
				Assert.assertEquals(acutalErrorMessage, errorMessage,"Invalid Test data verification");
				CommonMethods.wait(3000);

	}

	@DataProvider(name="userDataFromExcel")
	public Object[][] getData(){
		return ExcelUtility.excelToArray(Constants.EXCEL_FILEPATH, "Sheet3");
	}
}
