package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_018
 * TestScript Name: TYSS_Podcast_018
 * Description: Verify whether user can Play or pause by clicking on play button.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_018 extends BaseTest {

	@Test(description = "Verify whether user can Play or pause by clicking on play button")
	public void TC_TYSS_Podcast_018() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Click on paly or pause button and validate */
		pages.podCastPage.clkOnPlayOrPauseButton();

	}
}
