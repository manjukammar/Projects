package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_008
 * TestScript Name: TYSS_Podcast_008
 * Description: Verify whether user can view and scroll left or right by clicking on arrow navigation button in Bollywood, Binge and Beyond section.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_008 extends BaseTest {
	@Test(description = "Verify whether user can view and scroll left or right by clicking on arrow navigation button in Bollywood, Binge and Beyond section")
	public void TC_TYSS_Podcast_008() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Click right arrow icon under Bollywood bing beyond */
		pages.podCastPage.clkOnRightArrowIcn(prop_constants.getProperty("bollywood_bing_beyond"));

		/* Validate Bollywood bing beyond Title */
		pages.podCastPage.validateTitle(prop_constants.getProperty("bollywood_bing_beyond"));

	}
}
