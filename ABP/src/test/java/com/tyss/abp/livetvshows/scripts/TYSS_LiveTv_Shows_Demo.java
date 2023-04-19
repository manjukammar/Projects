package com.tyss.abp.livetvshows.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: LiveTv_Shows_001
 * TestScript Name: TYSS_LiveTv_Shows_001
 * Description: Verify whether user is able to Scroll Right or Left on the TV shows widget on live tv page.
 * 
 * Author: Manjappa 
 */
public class TYSS_LiveTv_Shows_Demo extends BaseTest {

	@Test(description = "Verify whether user is able to Scroll Right or Left on the TV shows widget on live tv page.")
	public void TC_TYSS_LiveTv_Shows_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on live TV link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_tv"));
		
		/* Validate Video page */
		pages.liveTvShowsPage.clkOnAnyVideoOnTvShow(prop_constants.getProperty("master_stroke"), prop_constants.getProperty("master_stroke"));
		
		/* Validate respective Videos displayed */
		pages.liveTvShowsPage.validateViewVideos();
		
		/* Click on Video */
		pages.liveTvShowsPage.clkOnVideo();
		
		/* Validate video is playing */
		pages.liveTvShowsPage.validateVideoIsPalying();
		
	}
}
