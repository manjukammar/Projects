package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_010
 * TestScript Name: TYSS_Cricket_010
 * Description:Verify when user click on view more button user is able to navigate to respective page .
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_010 extends BaseTest {
	@Test(description = "Verify when user click on view more button user is able to navigate to respective page")
	public void TC_TYSS_Cricket_010() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* click on View more */
		pages.cricketPage.clkOnViewMore(prop_constants.getProperty("textViewMore"));

		/* validate User should able to view ViewMore page */
		pages.cricketPage.validateViewMorePage(prop_constants.getProperty("textNews"));

	}
}