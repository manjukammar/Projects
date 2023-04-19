package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Home_007
 * TestScript Name: TYSS_Home_007
 * Description: Verify whether user is able to click on Games widget on home page.
 * 
 * Author: Sreelatha
 */
public class TYSS_Home_007 extends BaseTest {

	@Test(description = "Verify whether user is able to click on Games widget on home page")
	public void TC_TYSS_Home_007() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Games Widget */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_games"));
		
		/* Validate Games Page */
		pages.homePage.validatePage(prop_constants.getProperty("validate_Games"));
	
	}
}
