package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_004
 * TestScript Name: TYSS_Cricket_004
 * Description: Verify whether user is able to view wah Cricket page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_004 extends BaseTest {
	@Test(description = "Verify whether user is able to view wah Cricket page")
	public void TC_TYSS_Cricket_004() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* validate User should able to view wah Cricket page */
		pages.cricketPage.validateWahcricketPage();

	}
}