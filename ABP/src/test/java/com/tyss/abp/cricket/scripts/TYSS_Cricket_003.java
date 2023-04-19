package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_003
 * TestScript Name: TYSS_Cricket_003
 * Description: Verify when user click Home category able to  navigate to Home Page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_003 extends BaseTest {
	@Test(description = "Verify when user click Home category able to  navigate to Home Page")
	public void TC_TYSS_Cricket_003() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* click on home tab */
		pages.cricketPage.clkOnHomeCategory(prop_constants.getProperty("tabHome"));

		/* validate User should able to view the Home Page */
		pages.cricketPage.validateHomePage();

	}
}