package com.tyss.abp.videos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Videos_005
 * TestScript Name: TYSS_Videos_005
 * Description: Verify whether user is able to view and click the Entertainment on video page
 *
 * Author: Sanjay
 */
public class TYSS_Videos_005 extends BaseTest {

	@Test(description = "Verify whether user is able to view and click the Entertainment on video page")
	public void TC_TYSS_Videos_005() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Video link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_videos"));
		
		/* Click on view all option under Entertainment */
		pages.videosPage.clkOnViewAllButtonOfCategory(prop_constants.getProperty("entertainment_ViewAll"));
		
		/* Click on any story */
		String storytitle = pages.videosPage.clkOnFirstStory();
		
		/* Validate story title */
		pages.videosPage.validateStoryTitle(storytitle);
		

		

	}
}
