package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_013
 * TestScript Name: TYSS_Podcast_013
 * Description: Verify whether user can share the podcast link by clicking on facebook icon
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_013 extends BaseTest {

	@Test(description = "Verify whether user can share the podcast link by clicking on facebook icon")
	public void TC_TYSS_Podcast_013() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Click on facebook icon and validate facebook login page */
		pages.podCastPage.clkOnFacebookIconAndValidateFacebookLoginPage();

	}
}
