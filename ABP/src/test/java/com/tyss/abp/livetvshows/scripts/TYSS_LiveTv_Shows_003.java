package com.tyss.abp.livetvshows.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: LiveTv_Shows_003
 * TestScript Name: TYSS_LiveTv_Shows_003
 * Description: Verify whether user is able to click on tv shows videos, user should navigate to respective page and video should play.
 * Author: Manjappa 
 */
public class TYSS_LiveTv_Shows_003 extends BaseTest {

	@Test(description = "Verify whether user is able to click on tv shows videos, user should navigate to respective page and video should play")
	public void TC_TYSS_LiveTv_Shows_003() {

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
