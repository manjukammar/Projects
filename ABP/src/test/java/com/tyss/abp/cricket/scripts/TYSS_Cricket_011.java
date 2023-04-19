package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_011
 * TestScript Name: TYSS_Cricket_011
 * Description:Verify whether user is able to view Schedule section in Cricket page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_011 extends BaseTest {
	@Test(description = "Verify whether user is able to view Schedule section in Cricket page")
	public void TC_TYSS_Cricket_011() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* validate User should able to view Schedule section */
		pages.cricketPage.validateSchedule(prop_constants.getProperty("textSchedule"));

	}
}