package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_014
 * TestScript Name: TYSS_Cricket_014
 * Description:Verify whether user is able to view and click the footer.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_014 extends BaseTest {
	@Test(description = "Verify whether user is able to view and click the footer")
	public void TC_TYSS_Cricket_014() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* validate User should able to view Random footer section */
		pages.cricketPage.validateRandomFooter();

	}
}