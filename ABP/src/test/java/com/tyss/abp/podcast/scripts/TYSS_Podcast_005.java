package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_005
 * TestScript Name: TYSS_Podcast_005
 * Description: Verify whether user can view and click on the Let's catch up section.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_005 extends BaseTest {

	@Test(description = "Verify whether user can view and click on the Let's catch up section")
	public void TC_TYSS_Podcast_005() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Scroll and click on Lets catch up title */
		pages.podCastPage.clkOnTheTitle(prop_constants.getProperty("lets_catch_up"));

		/* Validate Lets catch up url and title of Lets catch up */
		pages.podCastPage.validatePage(prop_constants.getProperty("letsCatchUp_url"),
				prop_constants.getProperty("validate_Let_S_Catch_Up"));

	}
}
