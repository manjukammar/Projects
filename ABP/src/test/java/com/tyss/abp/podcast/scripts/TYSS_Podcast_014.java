package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_014
 * TestScript Name: TYSS_Podcast_014
 * Description: Verify whether user can share the podcast link by clicking on Twitter icon.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_014 extends BaseTest {

	@Test(description = "Verify whether user can share the podcast link by clicking on Twitter icon")
	public void TC_TYSS_Podcast_014() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Click on twitter icon and validate twitter login page */
		pages.podCastPage.clkOnTwitterIconAndValidateTwitterLoginPage();
	}
}
