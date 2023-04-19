package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_001
 * TestScript Name: TYSS_Cricket_001
 * Description: Verify whether user is able to view the Cricket category in Home Page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_001 extends BaseTest {
	@Test(description = "Verify whether user is able to view the Cricket category in Home Page")
	public void TC_TYSS_Cricket_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* validate user should be able to view the Cricket category */
		pages.cricketPage.validateCricketCategory(prop_constants.getProperty("linkCricket"));

	}
}