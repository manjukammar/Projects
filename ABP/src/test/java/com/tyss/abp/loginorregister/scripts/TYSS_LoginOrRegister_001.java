package com.tyss.abp.loginorregister.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: LoginOrRegister_001
 * TestScript Name: TYSS_LoginOrRegister_001
 * Description: Verify whether user can click on Login/Register widget user is redirected to the Login/Register on same tab
 * 
 * Author: Sanjay
 */
public class TYSS_LoginOrRegister_001 extends BaseTest {

	@Test(description = "Verify whether user can click on Login/Register widget user is redirected to the Login/Register on same tab")
	public void TC_TYSS_LoginOrRegister_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Login Or Register link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_loginregister"));
		
		/* Validate Login page */
		pages.homePage.validatePage(prop_constants.getProperty("txt_Login"));
	
	}
}
