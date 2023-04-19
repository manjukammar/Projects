package com.tyss.abp.livetv.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:LiveTv_003
 * TestScript Name: TYSS_LiveTv_003
 * Description:Verify whether user is able to view and click the Top stories on live tv page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_LiveTv_003 extends BaseTest {
	@Test(description = "Verify whether user is able to view and click the Top stories on live tv page")
	public void TC_TYSS_LiveTv_003() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on live tv link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_tv"));

		/* validate User should be able to view the top stories */
		pages.liveTvPage.validateTopStories();

		/* Click on view all option under Top stories */
		pages.liveTvPage.clickOnViewAll(prop_constants.getProperty("top_stories_ViewAll"));

		/* Click on any stories */
		pages.liveTvPage.clickOnAnyStoryOrVideoOrCardDisplayed();

	}
}