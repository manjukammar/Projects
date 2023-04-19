package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Home_006
 * TestScript Name: TYSS_Home_006
 * Description: Verify whether user is able to click on Podcast widget on home page.
 * 
 * Author: Sreelatha
 */
public class TYSS_Home_006 extends BaseTest {

	@Test(description = "Verify whether user is able to click on Podcast widget on home page")
	public void TC_TYSS_Home_006() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Podcast Widget */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_podcast"));
	
		/* Validate PodCast Page */
		pages.podCastPage.validatePage(prop_constants.getProperty("podcasts_url"), prop_constants.getProperty("validate_Podcast"));
	}
}
