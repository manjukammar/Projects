package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Podcast_004
 * TestScript Name: TYSS_Podcast_004
 * Description: Verify whether user can view and click on the Podcast shows on podcast page.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_004 extends BaseTest {

	@Test(description = "Verify whether user can view and click on the Podcast shows on podcast page")
	public void TC_TYSS_Podcast_004() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/*Click on podcast link*/
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));
		
		/*Scroll and click on podcast shows title */
		pages.podCastPage.clkOnTheTitle(prop_constants.getProperty("podcast_shows"));
		
		/*Validate Podcast url and title of podcast*/
		pages.podCastPage.validatePage(prop_constants.getProperty("podcasts_url"), prop_constants.getProperty("validate_Podcast"));
		
	
	}
}
