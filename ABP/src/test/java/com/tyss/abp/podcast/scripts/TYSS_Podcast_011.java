package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_011
 * TestScript Name: TYSS_Podcast_011
 * Description: Verify whether user can view and scroll left or right by clicking on arrow navigation button in OMG! IS THAT REAL? section.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_011 extends BaseTest {

	@Test(description = "Verify whether user can view and scroll left or right by clicking on arrow navigation button in OMG! IS THAT REAL? section")
	public void TC_TYSS_Podcast_011() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Click right arrow icon under omg_is_that_real */
		pages.podCastPage.clkOnRightArrowIcn(prop_constants.getProperty("omg_is_that_real"));

		/* Validate title of omg_is_that_real */
		pages.podCastPage.validateTitle(prop_constants.getProperty("omg_is_that_real"));

	}
}
