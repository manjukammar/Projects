package com.tyss.abp.videos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Videos_006
 * TestScript Name: TYSS_Videos_006
 * Description: Verify whether user is able to view and click the Sports on video page
 *
 * Author: Sanjay
 */
public class TYSS_Videos_006 extends BaseTest {

	@Test(description = "Verify whether user is able to view and click the Sports on video page")
	public void TC_TYSS_Videos_006() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Video link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_videos"));
		
		/* Click on view all option under Sports */
		pages.videosPage.clkOnViewAllButtonOfCategory(prop_constants.getProperty("sports_ViewAll"));
		
		/* Click on any story */
		String storytitle = pages.videosPage.clkOnFirstStory();
		
		/* Validate story title */
		pages.videosPage.validateStoryTitle(storytitle);
		

		

	}
}
