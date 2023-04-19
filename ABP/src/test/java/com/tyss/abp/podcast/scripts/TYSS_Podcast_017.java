package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_017
 * TestScript Name: TYSS_Podcast_017
 * Description: Verify whether user can mute and unmute volume by clicking volume icon.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_017 extends BaseTest {

	@Test(description = "Verify whether user can mute and unmute volume by clicking volume icon ")
	public void TC_TYSS_Podcast_017() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Click on Mute or Unmute button and validate */
		pages.podCastPage.clkOnMuteOrUnmuteButton();

	}
}
