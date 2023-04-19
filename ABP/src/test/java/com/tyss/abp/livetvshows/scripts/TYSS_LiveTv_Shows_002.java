package com.tyss.abp.livetvshows.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: LiveTv_Shows_002
 * TestScript Name: TYSS_LiveTv_Shows_002
 * Description: Verify whether user is able to click on tv shows videos.
 * Author: Manjappa 
 */
public class TYSS_LiveTv_Shows_002 extends BaseTest {

	@Test(description = "Verify whether user is able to click on tv shows videos.")
	public void TC_TYSS_LiveTv_Shows_002() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on live TV link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_tv"));
		
		/* Validate Video page */
		pages.liveTvShowsPage.clkOnAnyVideoOnTvShow(prop_constants.getProperty("master_stroke"), prop_constants.getProperty("master_stroke"));
	}
}
