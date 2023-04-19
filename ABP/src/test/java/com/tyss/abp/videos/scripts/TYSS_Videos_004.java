package com.tyss.abp.videos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Videos_004
 * TestScript Name: TYSS_Videos_004
 * Description: Verify whether user is able to view and click the News on video page
 *
 * Author: Sanjay
 */
public class TYSS_Videos_004 extends BaseTest {

	@Test(description = "Verify whether user is able to view and click the News on video page")
	public void TC_TYSS_Videos_004() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Video link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_videos"));
		
		/* Click on view all option under News */
		pages.videosPage.clkOnViewAllButtonOfCategory(prop_constants.getProperty("news_ViewAll"));
		
		/* Click on any story */
		String storytitle = pages.videosPage.clkOnFirstStory();
		
		/* Validate story title */
		pages.videosPage.validateStoryTitle(storytitle);
		

		

	}
}
