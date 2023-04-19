package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Home_008
 * TestScript Name: TYSS_Home_008
 * Description: Verify whether user is able to click on Login/Register  widget on home page.
 * 
 * Author: Sreelatha
 */
public class TYSS_Home_008 extends BaseTest {

	@Test(description = "Verify whether user is able to click on Login/Register  widget on home page")
	public void TC_TYSS_Home_008() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Login or Register Widget */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_loginregister"));
		
		/* Validate Login or Register page */
		pages.homePage.validatePage(prop_constants.getProperty("txt_Login"));
	
	}
}
