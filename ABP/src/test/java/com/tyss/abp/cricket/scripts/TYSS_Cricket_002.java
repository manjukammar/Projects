package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_002
 * TestScript Name: TYSS_Cricket_002
 * Description: Verify when user click Cricket category able to  navigate to Cricket Page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_002 extends BaseTest {

	@Test(description = "Verify when user click Cricket category able to  navigate to Cricket Page")
	public void TC_TYSS_Cricket_002() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* Click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* validate User should able to view the Cricket Page */
		pages.cricketPage.validateCricketPage();

	}
}