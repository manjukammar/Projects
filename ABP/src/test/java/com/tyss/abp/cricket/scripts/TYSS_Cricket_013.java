package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_013
 * TestScript Name: TYSS_Cricket_013
 * Description:Verify whether user is able to view Latest news section in Cricket page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_013 extends BaseTest {
	@Test(description = "Verify whether user is able to view Latest news section in Cricket page")
	public void TC_TYSS_Cricket_013() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* validate User should able to view Latest News section */
		pages.cricketPage.validateLatestNews(prop_constants.getProperty("textLatestNews"));

	}
}