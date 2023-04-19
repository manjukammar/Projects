package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_015
 * TestScript Name: TYSS_Podcast_015
 * Description: Verify whether user can share the podcast link by clicking on What's app icon.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_015 extends BaseTest {

	@Test(description = "Verify whether user can share the podcast link by clicking on What's app icon")
	public void TC_TYSS_Podcast_015() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on podcast link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));

		/* Click on watsapp icon and validate watsapp login page */
		pages.podCastPage.clkOnWhatsappIconAndValidateWhatsappWebPage();

	}
}
