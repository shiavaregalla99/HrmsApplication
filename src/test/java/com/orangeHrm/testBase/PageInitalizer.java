package com.orangeHrm.testBase;

import com.oragneHrm.pages.DashBoardPage;
import com.oragneHrm.pages.LoginPage;

public class PageInitalizer extends BaseClass{

	public static LoginPage login;
	public static DashBoardPage dashBoard;
	public static void intialize() {
		login= new LoginPage();
		dashBoard= new DashBoardPage();
	}
}
