package com.tyss.abp.livetv.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:LiveTv_006
 * TestScript Name: TYSS_LiveTv_006
 * Description:Verify whether user is able to view and click the Entertainment on live tv page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_LiveTv_006 extends BaseTest {
	@Test(description = "Verify whether user is able to view and click the Entertainment on live tv page")
	public void TC_TYSS_LiveTv_006() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on live tv link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_tv"));

		/* Click on view all option under entertainment category */
		pages.homePage.clickOnViewAll(prop_constants.getProperty("entertainment_sectionType"));

		/* Click on any stories */
		pages.liveTvPage.clickOnAnyStoryOrVideoOrCardDisplayed();

		/* validate User should be able to view and navigate to the news page */
		pages.liveTvPage.validateHeader(prop_constants.getProperty("entertainment_sectionType"));

	}
}