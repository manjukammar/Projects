package com.tyss.abp.videos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Videos_007
 * TestScript Name: TYSS_Videos_007
 * Description: Verify whether user is able to view and click on See More button
 *
 * Author: Sanjay
 */
public class TYSS_Videos_007 extends BaseTest {

	@Test(description = "Verify whether user is able to view and click on See More button")
	public void TC_TYSS_Videos_007() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Video link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_videos"));
		
		/* Click on See More button */
		pages.videosPage.clkOnSeeMoreButton();
		
		/* Validate More Videos loaded */
		pages.videosPage.validateMoreVideosLoaded();
		

		

	}
}
