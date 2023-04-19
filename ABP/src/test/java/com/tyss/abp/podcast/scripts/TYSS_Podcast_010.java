package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_010
 * TestScript Name: TYSS_Podcast_010
 * Description: Verify whether user can view and click on  OMG! IS THAT REAL? section.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_010 extends BaseTest {

	@Test(description = "Verify whether user can view and click on  OMG! IS THAT REAL? section")
	public void TC_TYSS_Podcast_010() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Scroll and click on omg_is_that_real title */
		pages.podCastPage.clkOnTheTitle(prop_constants.getProperty("omg_is_that_real"));

		/* Validate omg_is_that_real url and title of Omg_Is_That_Real */
		pages.podCastPage.validatePage(prop_constants.getProperty("omgIsThatReal_url"),
				prop_constants.getProperty("validate_Omg_Is_That_Real"));

	}
}
