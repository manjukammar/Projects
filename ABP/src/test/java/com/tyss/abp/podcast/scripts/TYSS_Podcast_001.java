package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_001
 * TestScript Name: TYSS_Podcast_001
 * Description: Verify whether user is able to redirect to podcast page once clicked on podcast widget on top of the home page.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_001 extends BaseTest {

	@Test(description = "Verify whether user is able to redirect to podcast page once clicked on podcast widget on top of the home page")
	public void TC_TYSS_Podcast_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/*Click on podcast link*/
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));
		
		/*Validate Podcast url and title of podcast*/
		pages.podCastPage.validatePage(prop_constants.getProperty("podcasts_url"), prop_constants.getProperty("validate_Podcast"));
	
	}
}
