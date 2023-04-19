package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_016
 * TestScript Name: TYSS_Podcast_016
 * Description: Verify whether user can change the volume by clicking on volume slider.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_016 extends BaseTest {

	@Test(description = "Verify whether user can change the volume by clicking on volume slider ")
	public void TC_TYSS_Podcast_016() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Modify the volume in podcast page */
		pages.podCastPage.modifyTheVolume(prop_constants.getProperty("count"));

	}
}
