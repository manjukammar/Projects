package com.tyss.abp.videos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Videos_002
 * TestScript Name: TYSS_Videos_002
 * Description: Verify whether user can click on Uncut in video page
 *
 * Author: Sanjay
 */
public class TYSS_Videos_002 extends BaseTest {

	@Test(description = "Verify whether user can click on Uncut in video page")
	public void TC_TYSS_Videos_002() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Video link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_videos"));
		
		/* Click on Uncut link */
		pages.videosPage.clkOnLinksInVideosPage(prop_constants.getProperty("lnk_Uncut"));
		
		/* Validate Uncut page */
		pages.videosPage.validateUncutPage();
		
		

		

	}
}
