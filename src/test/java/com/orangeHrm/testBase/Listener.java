package com.orangeHrm.testBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.orangeHrm.utils.CommonMethods;

public class Listener implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		BaseClass.test=BaseClass.report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		CommonMethods.takeScreenShot("/Passed/" +result.getName());
		
	}
@Override
	public void onTestFailure(ITestResult result) {
		
	CommonMethods.takeScreenShot("/Failed/" +result.getName());
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	

}
