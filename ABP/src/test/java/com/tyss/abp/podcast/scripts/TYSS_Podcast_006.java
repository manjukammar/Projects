package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_006
 * TestScript Name: TYSS_Podcast_006
 * Description: Verify whether user can view, Listen and  click on the Let's catch up section view all button.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_006 extends BaseTest {

	@Test(description = "Verify whether user can view, Listen and  click on the Let's catch up section view all button")
	public void TC_TYSS_Podcast_006() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Scroll and click on Lets catch up view Title */
		pages.podCastPage.clkOnViewAllBtn(prop_constants.getProperty("lets_catch_up"));

		/* Validate Lets catch up url and title of Lets catch up */
		pages.podCastPage.validatePage(prop_constants.getProperty("letsCatchUp_url"),
				prop_constants.getProperty("validate_Let_S_Catch_Up"));

	}
}
