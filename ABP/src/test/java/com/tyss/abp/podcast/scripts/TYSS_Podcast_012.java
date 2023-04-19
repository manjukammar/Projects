package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_012
 * TestScript Name: TYSS_Podcast_012
 * Description: Verify whether user can view, listen and  click on the OMG! IS THAT REAL? section view all button.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_012 extends BaseTest {
	@Test(description = "Verify whether user can view, listen and  click on the OMG! IS THAT REAL? section view all button")
	public void TC_TYSS_Podcast_012() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Scroll and click on omg_is_that_real view all button */
		pages.podCastPage.clkOnViewAllBtn(prop_constants.getProperty("omg_is_that_real"));

		/* Validate omg_is_that_real url and title of omg_is_that_real */
		pages.podCastPage.validatePage(prop_constants.getProperty("omgIsThatReal_url"),
				prop_constants.getProperty("validate_Omg_Is_That_Real"));

	}
}
