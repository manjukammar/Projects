package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_007
 * TestScript Name: TYSS_Cricket_007
 * Description:Verify whether user is able to view TEAM RANKINGS section in Cricket page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_007 extends BaseTest {
	@Test(description = "Verify whether user is able to view TEAM RANKINGS section in Cricket page")
	public void TC_TYSS_Cricket_007() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* validate User should able to view Team ranking section */
		pages.cricketPage.validateTeamRanking();

	}
}