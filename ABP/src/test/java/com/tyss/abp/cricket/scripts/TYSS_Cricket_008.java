package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_008
 * TestScript Name: TYSS_Cricket_008
 * Description:Verify when user click any one video it should navigate to respective page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_008 extends BaseTest {
	@Test(description = "Verify when user click any one video it should navigate to respective page")
	public void TC_TYSS_Cricket_008() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* click on video */
		pages.cricketPage.clkOnVideo();

		/* validate User should able to view video page */
		pages.cricketPage.validateVideoPage();

	}
}