package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_009
 * TestScript Name: TYSS_Podcast_009
 * Description: Verify whether user can view, listen and  click on the Bollywood, Binge and Beyond section view all button.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_009 extends BaseTest {

	@Test(description = "Verify whether user can view, listen and  click on the Bollywood, Binge and Beyond section view all button")
	public void TC_TYSS_Podcast_009() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Scroll and click on bollywood bing beyond view all button */
		pages.podCastPage.clkOnViewAllBtn(prop_constants.getProperty("bollywood_bing_beyond"));

		/* Validate bollywoodBingeAndBeyond url and title of bollywoodBingeAndBeyond */
		pages.podCastPage.validatePage(prop_constants.getProperty("bollywoodBingeAndBeyond_url"),
				prop_constants.getProperty("validate_Bollywood_Binge_And_Beyond"));

	}
}
