package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_019
 * TestScript Name: TYSS_Podcast_019
 * Description: Verify whether user can switch to next or previous podcast by clicking on arrow button.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_019 extends BaseTest {

	@Test(description = "Verify whether user can switch to next or previous podcast by clicking on arrow button")
	public void TC_TYSS_Podcast_019() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Click on next or previous podcast button */
		pages.podCastPage.clkonNextOrPreviousPodcastButton();
	}
}
