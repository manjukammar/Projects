package com.tyss.abp.videos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Videos_001
 * TestScript Name: TYSS_Videos_001
 * Description: Verify whether user is able to view the Video page  when click on video link 
 *
 * Author: Sanjay
 */
public class TYSS_Videos_001 extends BaseTest {

	@Test(description = "Verify whether user is able to view the Video page  when click on video link")
	public void TC_TYSS_Videos_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Video link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_videos"));
		
		/* Validate videos, uncut and tv-shows link */
		pages.videosPage.validateVideoUncutTvLinks();
		
		

		

	}
}
