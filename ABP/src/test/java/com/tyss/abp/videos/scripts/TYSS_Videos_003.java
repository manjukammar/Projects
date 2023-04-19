package com.tyss.abp.videos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Videos_003
 * TestScript Name: TYSS_Videos_003
 * Description: Verify whether user can click on tv-shows in video page
 *
 * Author: Sanjay
 */
public class TYSS_Videos_003 extends BaseTest {

	@Test(description = "Verify whether user can click on tv-shows in video page")
	public void TC_TYSS_Videos_003() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Video link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_videos"));
		
		/* Click on tv-shows link */
		pages.videosPage.clkOnLinksInVideosPage(prop_constants.getProperty("lnk_TVShows"));
		
		/* Validate tv-shows page */
		pages.videosPage.validateTvShowsPage();
		

		

	}
}
