package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_009
 * TestScript Name: TYSS_Cricket_009
 * Description:Verify when user click any one photo it should navigate to respective page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_009 extends BaseTest {
	@Test(description = "Verify when user click any one photo it should navigate to respective page")
	public void TC_TYSS_Cricket_009() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* click on photo */
		pages.cricketPage.clkOnPhoto();

		/* validate User should able to view photo page */
		pages.cricketPage.validatePhotoPage();

	}
}