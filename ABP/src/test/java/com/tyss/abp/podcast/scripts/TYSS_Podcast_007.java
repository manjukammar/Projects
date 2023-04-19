package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Podcast_007
 * TestScript Name: TYSS_Podcast_007
 * Description: Verify whether user can view and click on Bollywood, Binge and Beyond section.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_007 extends BaseTest {

	@Test(description = "Verify whether user can view and click on Bollywood, Binge and Beyond section")
	public void TC_TYSS_Podcast_007() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/*Click on podcast link*/
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));
		
		/*Scroll and click on Bollywood bing beyond Title */
		pages.podCastPage.clkOnTheTitle(prop_constants.getProperty("bollywood_bing_beyond"));
		
		/*Validate bollywoodBingeAndBeyond url and title of bollywoodBingeAndBeyond*/
		pages.podCastPage.validatePage(prop_constants.getProperty("bollywoodBingeAndBeyond_url"), prop_constants.getProperty("validate_Bollywood_Binge_And_Beyond"));
		
		
	
	}
}
