package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Podcast_003
 * TestScript Name: TYSS_Podcast_003
 * Description: Verify whether view all button is fuctioning in the Podcast Show Section.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_003 extends BaseTest {

	@Test(description = "Verify whether view all button is fuctioning in the Podcast Show Section" )
	public void TC_TYSS_Podcast_003() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/*Click on podcast link*/
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));
		
		/*Scroll and click on view all button */
		pages.podCastPage.clkOnViewAllBtn(prop_constants.getProperty("podcast_shows"));
		
		/*Validate Podcast url and title of podcast*/
		pages.podCastPage.validatePage(prop_constants.getProperty("podcasts_url"), prop_constants.getProperty("validate_Podcast"));
	
	}
}
