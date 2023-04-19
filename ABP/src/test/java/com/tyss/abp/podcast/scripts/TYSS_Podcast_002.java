package com.tyss.abp.podcast.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: podcast_002
 * TestScript Name: TYSS_podcast_002
 * Description: Verify whether audio of podcast is auto played as soon user clicked on podcast widget.
 * 
 * Author: Ramya R
 */
public class TYSS_Podcast_002 extends BaseTest {

	@Test(description = "Verify whether audio of podcast is auto played as soon user clicked on podcast widget")
	public void TC_TYSS_Podcast_002() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/*Click on podcast link*/
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));
		
		/*validate Pause button*/
		pages.podCastPage.validatePauseBtn();
		
	
	}
}
